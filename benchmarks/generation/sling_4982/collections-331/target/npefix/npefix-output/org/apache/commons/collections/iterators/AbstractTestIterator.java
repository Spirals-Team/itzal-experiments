package org.apache.commons.collections.iterators;

import java.util.NoSuchElementException;
import java.util.Iterator;
import junit.framework.Assert;
import org.apache.commons.collections.AbstractTestObject;

public abstract class AbstractTestIterator<E> extends AbstractTestObject {
    public AbstractTestIterator(String testName) {
        super(testName);
    }

    public abstract Iterator<E> makeEmptyIterator();

    @Override
    public abstract Iterator<E> makeObject();

    public boolean supportsEmptyIterator() {
        return true;
    }

    public boolean supportsFullIterator() {
        return true;
    }

    public boolean supportsRemove() {
        return true;
    }

    public void verify() {
    }

    public void testEmptyIterator() {
        if ((supportsEmptyIterator()) == false) {
            return ;
        }
        Iterator<E> it = makeEmptyIterator();
        Assert.assertEquals("hasNext() should return false for empty iterators", false, it.hasNext());
        try {
            it.next();
            Assert.fail("NoSuchElementException must be thrown when Iterator is exhausted");
        } catch (NoSuchElementException e) {
        }
        verify();
        Assert.assertNotNull(it.toString());
    }

    public void testFullIterator() {
        if ((supportsFullIterator()) == false) {
            return ;
        }
        Iterator<E> it = makeObject();
        Assert.assertEquals("hasNext() should return true for at least one element", true, it.hasNext());
        try {
            it.next();
        } catch (NoSuchElementException e) {
            Assert.fail("Full iterators must have at least one element");
        }
        while (it.hasNext()) {
            it.next();
            verify();
        } 
        try {
            it.next();
            Assert.fail("NoSuchElementException must be thrown when Iterator is exhausted");
        } catch (NoSuchElementException e) {
        }
        Assert.assertNotNull(it.toString());
    }

    public void testRemove() {
        Iterator<E> it = makeObject();
        if ((supportsRemove()) == false) {
            try {
                it.remove();
            } catch (UnsupportedOperationException ex) {
            }
            return ;
        }
        try {
            it.remove();
            Assert.fail();
        } catch (IllegalStateException ex) {
        }
        verify();
        it.next();
        it.remove();
        try {
            it.remove();
            Assert.fail();
        } catch (IllegalStateException ex) {
        }
    }
}

