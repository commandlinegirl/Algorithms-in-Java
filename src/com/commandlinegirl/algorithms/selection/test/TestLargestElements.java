package com.commandlinegirl.algorithms.selection.test;

import com.commandlinegirl.algorithms.selection.LargestElements;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLargestElements {

    @Test
    public void testSorting() {
        LargestElements le = new LargestElements();
        int[] ar = new int[]{10, 4, 8, 3, 2, 5, 10, 1001, 4, 5, 6};
        int result = le.findSecondLargest(ar);
        int expected = 10;
        assertEquals(expected, result);
    }

    @Test
    public void testSorting_nondistinct() {
        LargestElements le = new LargestElements();
        int[] ar = new int[]{10, 10};
        int result = le.findSecondLargest(ar);
        int expected = -1;
        assertEquals(expected, result);
    }
}
