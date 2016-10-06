package com.commandlinegirl.algorithms.selection.test;

import com.commandlinegirl.algorithms.selection.Quickselect;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestQuickselect {

    @Test
    public void testSorting() {
        Quickselect qselect = new Quickselect();
        int[] ar = new int[]{10, 4, 8, 3, 2, 5, 10, 1001, 4, 5, 6};
        int result = qselect.getKthSmallestElement(ar, 3);
        int expected = 4;
        //int[] expectedSortedArr = new int[]{2, 3, 4, 4, 5, 5, 6, 8, 10, 10, 1001};
        assertEquals(expected, result);
    }
}
