package org.apache.commons.collections;

import junit.framework.TestSuite;
import junit.framework.TestCase;
import java.lang.reflect.Modifier;

public class BulkTest extends TestCase implements Cloneable {
    String verboseName;

    public BulkTest(String name) {
        super(name);
        this.verboseName = getClass().getName();
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error();
        }
    }

    public String[] ignoredTests() {
        return null;
    }

    @Override
    public String toString() {
        return (((getName()) + "(") + (verboseName)) + ") ";
    }

    public static TestSuite makeSuite(Class<? extends BulkTest> c) {
        if (Modifier.isAbstract(c.getModifiers())) {
            throw new IllegalArgumentException("Class must not be abstract.");
        }
        if (!(BulkTest.class.isAssignableFrom(c))) {
            throw new IllegalArgumentException("Class must extend BulkTest.");
        }
        return new BulkTestSuiteMaker(c).make();
    }
}

