package org.apache.commons.collections.iterators;

import java.util.List;
import java.util.Comparator;
import org.apache.commons.collections.comparators.ComparableComparator;
import junit.framework.Assert;
import java.util.Arrays;
import java.util.ArrayList;

@SuppressWarnings(value = "boxing")
public class TestCollatingIterator extends AbstractTestIterator<Integer> {
    public TestCollatingIterator(String testName) {
        super(testName);
    }

    private Comparator<Integer> comparator = null;

    private ArrayList<Integer> evens = null;

    private ArrayList<Integer> odds = null;

    private ArrayList<Integer> fib = null;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        comparator = new ComparableComparator<Integer>();
        evens = new ArrayList<Integer>();
        odds = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            if (0 == (i % 2)) {
                evens.add(i);
            }else {
                odds.add(i);
            }
        }
        fib = new ArrayList<Integer>();
        fib.add(1);
        fib.add(1);
        fib.add(2);
        fib.add(3);
        fib.add(5);
        fib.add(8);
        fib.add(13);
        fib.add(21);
    }

    @Override
    public CollatingIterator<Integer> makeEmptyIterator() {
        return new CollatingIterator<Integer>(comparator);
    }

    @Override
    public CollatingIterator<Integer> makeObject() {
        CollatingIterator<Integer> iter = new CollatingIterator<Integer>(comparator);
        iter.addIterator(evens.iterator());
        iter.addIterator(odds.iterator());
        iter.addIterator(fib.iterator());
        return iter;
    }

    public void testNullComparator() {
        List<Integer> l1 = Arrays.asList(1, 3, 5);
        List<Integer> l2 = Arrays.asList(2, 4, 6);
        CollatingIterator<Integer> collatingIterator1 = new CollatingIterator<Integer>(null, l1.iterator(), l2.iterator());
        try {
            collatingIterator1.next();
        } catch (NullPointerException e) {
            Assert.assertTrue(e.getMessage().startsWith("You must invoke setComparator"));
        }
        int i = 0;
        CollatingIterator<Integer> collatingIterator2 = new CollatingIterator<Integer>(null, l1.iterator(), l2.iterator());
        collatingIterator2.setComparator(new ComparableComparator<Integer>());
        for (; collatingIterator2.hasNext(); i++) {
            Integer n = ((Integer) (collatingIterator2.next()));
            Assert.assertEquals("wrong order", ((int) (n)), (i + 1));
        }
        Assert.assertEquals("wrong size", i, ((l1.size()) + (l2.size())));
    }
}

