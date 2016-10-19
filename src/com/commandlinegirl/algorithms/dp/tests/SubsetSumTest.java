package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.SubsetSum;
import org.junit.Assert;
import org.junit.Test;


public class SubsetSumTest {

    @Test
    public void testIsSubset_true() {
        SubsetSum ss = new SubsetSum();
        int[] s = {3, 1, 1, 2, 2, 1};
        Assert.assertTrue(ss.isSubsetSum(s, 5));
    }

    @Test
    public void testIsSubset_false() {
        SubsetSum ss = new SubsetSum();
        int[] s = {3, 1};
        Assert.assertFalse(ss.isSubsetSum(s, 5));
    }

    @Test
    public void testIsSubset_empty() {
        SubsetSum ss = new SubsetSum();
        int[] s = {};
        Assert.assertFalse(ss.isSubsetSum(s, 5));
    }
}
