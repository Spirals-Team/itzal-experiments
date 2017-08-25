package org.apache.commons.collections;

import java.io.Serializable;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import junit.framework.Assert;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractTestObject extends BulkTest {
    public static final int COLLECTIONS_MAJOR_VERSION = 3;

    public AbstractTestObject(String testName) {
        super(testName);
    }

    public abstract Object makeObject();

    public boolean supportsEmptyCollections() {
        return true;
    }

    public boolean supportsFullCollections() {
        return true;
    }

    public boolean isTestSerialization() {
        return true;
    }

    public boolean isEqualsCheckable() {
        return true;
    }

    public void testObjectEqualsSelf() {
        Object obj = makeObject();
        Assert.assertEquals("A Object should equal itself", obj, obj);
    }

    public void testEqualsNull() {
        Object obj = makeObject();
        Assert.assertEquals(false, obj.equals(null));
    }

    public void testObjectHashCodeEqualsSelfHashCode() {
        Object obj = makeObject();
        Assert.assertEquals("hashCode should be repeatable", obj.hashCode(), obj.hashCode());
    }

    public void testObjectHashCodeEqualsContract() {
        Object obj1 = makeObject();
        if (obj1.equals(obj1)) {
            Assert.assertEquals("[1] When two objects are equal, their hashCodes should be also.", obj1.hashCode(), obj1.hashCode());
        }
        Object obj2 = makeObject();
        if (obj1.equals(obj2)) {
            Assert.assertEquals("[2] When two objects are equal, their hashCodes should be also.", obj1.hashCode(), obj2.hashCode());
            Assert.assertTrue("When obj1.equals(obj2) is true, then obj2.equals(obj1) should also be true", obj2.equals(obj1));
        }
    }

    protected Object serializeDeserialize(Object obj) throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buffer);
        out.writeObject(obj);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
        Object dest = in.readObject();
        in.close();
        return dest;
    }

    public void testSerializeDeserializeThenCompare() throws Exception {
        Object obj = makeObject();
        if ((obj instanceof Serializable) && (isTestSerialization())) {
            Object dest = serializeDeserialize(obj);
            if (isEqualsCheckable()) {
                Assert.assertEquals("obj != deserialize(serialize(obj))", obj, dest);
            }
        }
    }

    public void testSimpleSerialization() throws Exception {
        Object o = makeObject();
        if ((o instanceof Serializable) && (isTestSerialization())) {
            byte[] objekt = writeExternalFormToBytes(((Serializable) (o)));
            readExternalFormFromBytes(objekt);
        }
    }

    public void testCanonicalEmptyCollectionExists() {
        if (((supportsEmptyCollections()) && (isTestSerialization())) && (!(skipSerializedCanonicalTests()))) {
            Object object = makeObject();
            if (object instanceof Serializable) {
                String name = getCanonicalEmptyCollectionName(object);
                Assert.assertTrue((("Canonical empty collection (" + name) + ") is not in SVN"), new File(name).exists());
            }
        }
    }

    public void testCanonicalFullCollectionExists() {
        if (((supportsFullCollections()) && (isTestSerialization())) && (!(skipSerializedCanonicalTests()))) {
            Object object = makeObject();
            if (object instanceof Serializable) {
                String name = getCanonicalFullCollectionName(object);
                Assert.assertTrue((("Canonical full collection (" + name) + ") is not in SVN"), new File(name).exists());
            }
        }
    }

    public String getCompatibilityVersion() {
        return "1";
    }

    protected String getCanonicalEmptyCollectionName(Object object) {
        StringBuilder retval = new StringBuilder();
        retval.append("data/test/");
        String colName = object.getClass().getName();
        colName = colName.substring(((colName.lastIndexOf(".")) + 1), colName.length());
        retval.append(colName);
        retval.append(".emptyCollection.version");
        retval.append(getCompatibilityVersion());
        retval.append(".obj");
        return retval.toString();
    }

    protected String getCanonicalFullCollectionName(Object object) {
        StringBuilder retval = new StringBuilder();
        retval.append("data/test/");
        String colName = object.getClass().getName();
        colName = colName.substring(((colName.lastIndexOf(".")) + 1), colName.length());
        retval.append(colName);
        retval.append(".fullCollection.version");
        retval.append(getCompatibilityVersion());
        retval.append(".obj");
        return retval.toString();
    }

    protected void writeExternalFormToDisk(Serializable o, String path) throws IOException {
        FileOutputStream fileStream = new FileOutputStream(path);
        writeExternalFormToStream(o, fileStream);
    }

    protected byte[] writeExternalFormToBytes(Serializable o) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        writeExternalFormToStream(o, byteStream);
        return byteStream.toByteArray();
    }

    protected Object readExternalFormFromDisk(String path) throws IOException, ClassNotFoundException {
        FileInputStream stream = new FileInputStream(path);
        return readExternalFormFromStream(stream);
    }

    protected Object readExternalFormFromBytes(byte[] b) throws IOException, ClassNotFoundException {
        ByteArrayInputStream stream = new ByteArrayInputStream(b);
        return readExternalFormFromStream(stream);
    }

    protected boolean skipSerializedCanonicalTests() {
        return Boolean.getBoolean("org.apache.commons.collections:with-clover");
    }

    private Object readExternalFormFromStream(InputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream oStream = new ObjectInputStream(stream);
        return oStream.readObject();
    }

    private void writeExternalFormToStream(Serializable o, OutputStream stream) throws IOException {
        ObjectOutputStream oStream = new ObjectOutputStream(stream);
        oStream.writeObject(o);
    }
}

