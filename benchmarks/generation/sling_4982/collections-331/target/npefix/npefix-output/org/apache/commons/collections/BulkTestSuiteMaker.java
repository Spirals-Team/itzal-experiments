package org.apache.commons.collections;

import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class BulkTestSuiteMaker {
    private Class<? extends BulkTest> startingClass;

    private List<String> ignored;

    private TestSuite result;

    private String prefix;

    public BulkTestSuiteMaker(Class<? extends BulkTest> startingClass) {
        this.startingClass = startingClass;
    }

    public TestSuite make() {
        this.result = new TestSuite();
        this.prefix = BulkTestSuiteMaker.getBaseName(startingClass);
        result.setName(prefix);
        BulkTest bulk = BulkTestSuiteMaker.makeFirstTestCase(startingClass);
        ignored = new ArrayList<String>();
        String[] s = bulk.ignoredTests();
        if (s != null) {
            ignored.addAll(Arrays.asList(s));
        }
        make(bulk);
        return result;
    }

    void make(BulkTest bulk) {
        Class<? extends BulkTest> c = bulk.getClass();
        Method[] all = c.getMethods();
        for (int i = 0; i < (all.length); i++) {
            if (BulkTestSuiteMaker.isTest(all[i]))
                addTest(bulk, all[i]);
            
            if (BulkTestSuiteMaker.isBulk(all[i]))
                addBulk(bulk, all[i]);
            
        }
    }

    void addTest(BulkTest bulk, Method m) {
        BulkTest bulk2 = ((BulkTest) (bulk.clone()));
        bulk2.setName(m.getName());
        bulk2.verboseName = ((prefix) + ".") + (m.getName());
        if (ignored.contains(bulk2.verboseName))
            return ;
        
        result.addTest(bulk2);
    }

    void addBulk(BulkTest bulk, Method m) {
        String verboseName = ((prefix) + ".") + (m.getName());
        if (ignored.contains(verboseName))
            return ;
        
        BulkTest bulk2;
        try {
            bulk2 = ((BulkTest) (m.invoke(bulk, ((Object[]) (null)))));
            if (bulk2 == null)
                return ;
            
        } catch (InvocationTargetException ex) {
            ex.getTargetException().printStackTrace();
            throw new Error();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            throw new Error();
        }
        String oldPrefix = prefix;
        TestSuite oldResult = result;
        prefix = ((prefix) + ".") + (m.getName());
        result = new TestSuite();
        result.setName(m.getName());
        make(bulk2);
        oldResult.addTest(result);
        prefix = oldPrefix;
        result = oldResult;
    }

    private static String getBaseName(Class<?> c) {
        String name = c.getName();
        int p = name.lastIndexOf('.');
        if (p > 0) {
            name = name.substring((p + 1));
        }
        return name;
    }

    private static <T> Constructor<T> getTestCaseConstructor(Class<T> c) {
        try {
            return c.getConstructor(new Class[]{ String.class });
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(((c + " must provide ") + "a (String) constructor"));
        }
    }

    private static <T extends BulkTest> BulkTest makeTestCase(Class<T> c, Method m) {
        Constructor<T> con = BulkTestSuiteMaker.getTestCaseConstructor(c);
        try {
            return con.newInstance(new Object[]{ m.getName() });
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            throw new Error();
        } catch (InstantiationException e) {
            throw new RuntimeException();
        }
    }

    private static <T extends BulkTest> BulkTest makeFirstTestCase(Class<T> c) {
        Method[] all = c.getMethods();
        for (int i = 0; i < (all.length); i++) {
            if (BulkTestSuiteMaker.isTest(all[i]))
                return BulkTestSuiteMaker.makeTestCase(c, all[i]);
            
        }
        throw new IllegalArgumentException((((c.getName()) + " must provide ") + " at least one test method."));
    }

    private static boolean isTest(Method m) {
        if (!(m.getName().startsWith("test")))
            return false;
        
        if ((m.getReturnType()) != (Void.TYPE))
            return false;
        
        if ((m.getParameterTypes().length) != 0)
            return false;
        
        int mods = m.getModifiers();
        if (Modifier.isStatic(mods))
            return false;
        
        if (Modifier.isAbstract(mods))
            return false;
        
        return true;
    }

    private static boolean isBulk(Method m) {
        if (!(m.getName().startsWith("bulkTest")))
            return false;
        
        if ((m.getReturnType()) != (BulkTest.class))
            return false;
        
        if ((m.getParameterTypes().length) != 0)
            return false;
        
        int mods = m.getModifiers();
        if (Modifier.isStatic(mods))
            return false;
        
        if (Modifier.isAbstract(mods))
            return false;
        
        return true;
    }
}

