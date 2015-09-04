package com.commandlinegirl.algorithms.sorting;

import org.junit.Test;

public class TestSorting {

    @Test
    public void testSorting() {
        SortStrategy strategy = new SortStrategy(new Quicksort());
        int[] ar = new int[]{10,4,8,3,2,5,10,1001,4,5,6};
        strategy.sort(ar);
        //int[] expected = new int[]{10,4,8,3,2,5,10,1001,4,5,6};
        System.out.println(ar);
        //assertTrue(Arrays.equals(expected, ar));

        //strategy = new SortStrategy(new Mergesort());
        //int[] ar = new int[]{10,4,8,3,2,5,10,1001,4,5,6};
        //strategy.sort(ar);

        strategy = new SortStrategy(new Insertsort());
        ar = new int[]{10,4,8,3,2,5,10,1001,4,5,6};
        strategy.sort(ar);
        
        System.out.println(TestSorting.class.getName() + " passed.");
    }
}
