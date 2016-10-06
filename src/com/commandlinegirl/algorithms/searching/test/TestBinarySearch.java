package com.commandlinegirl.algorithms.searching.test;

import com.commandlinegirl.algorithms.searching.BinarySearch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TestBinarySearch {

    private BinarySearch bs;

    @Before
    public void setup() {
        bs = new BinarySearch();
    }

    @Test
    public void testBinarySearch_existing_element() {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 5, 10, 18);
        // Existing element
        int result = bs.binarySearch(list, 3);
        Assert.assertEquals(3, result);
    }

    @Test
    public void testBinarySearch_non_existing_element() {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 5, 10, 18);
        // Existing element
        int result = bs.binarySearch(list, 0);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testBinarySearch_empty_list() {
        List<Integer> list = new ArrayList<>();
        int result = bs.binarySearch(list, 20);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testBinarySearch_first_element() {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 5, 10, 18);
        int result = bs.binarySearch(list, 1);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testBinarySearch_last_element() {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 5, 10, 18);
        int result = bs.binarySearch(list, 18);
        Assert.assertEquals(7, result);
    }


}
