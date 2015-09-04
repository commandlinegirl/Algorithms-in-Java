package com.commandlinegirl.algorithms.sorting;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class TestSorting {

    @Test
    public void testSorting() {
        SortStrategy strategy = new SortStrategy(new Quicksort());
        int[] ar = new int[]{10,4,8,3,2,5,10,1001,4,5,6};
        strategy.sort(ar);
        int[] expected = new int[]{2, 3, 4, 4, 5, 5, 6, 8, 10, 10, 1001};
        assertTrue(Arrays.equals(expected, ar));

        strategy = new SortStrategy(new Mergesort());
        ar = new int[]{10,4,8,3,2,5,10,1001,4,5,6};
        strategy.sort(ar);
        assertTrue(Arrays.equals(expected, ar));

        strategy = new SortStrategy(new Insertsort());
        ar = new int[]{10,4,8,3,2,5,10,1001,4,5,6,888};
        strategy.sort(ar);
        expected = new int[]{2, 3, 4, 4, 5, 5, 6, 8, 10, 10, 888, 1001};
        assertTrue(Arrays.equals(expected, ar));
        
    }
}
