package com.commandlinegirl.algorithms.searching.test;

import com.commandlinegirl.algorithms.searching.IndexElement;
import org.junit.Test;

import org.junit.Assert;

public class TestIndexElement {

    @Test
    public void testIsEqualToIndex_true() {
        IndexElement ie = new IndexElement();
        int[] ar = {-2, -1, 1, 3, 9};
        Assert.assertTrue(ie.isEqualToIndex(ar));
    }

    @Test
    public void testIsEqualToIndex_false() {
        IndexElement ie = new IndexElement();
        int[] ar = {1, 2, 3, 4, 5};
        Assert.assertFalse(ie.isEqualToIndex(ar));
    }
}
