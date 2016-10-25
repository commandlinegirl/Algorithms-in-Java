package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.MaxSumIncreasingSubsequence;
import org.junit.Assert;
import org.junit.Test;

public class MaxSumIncreasingSubsequenceTest {

    @Test
    public void testLongestIncreasingSubsequence_empty() {
        MaxSumIncreasingSubsequence o = new MaxSumIncreasingSubsequence();
        int[] ar = {};
        int res = o.maxSumIncreasingSubsequence(ar);
        Assert.assertEquals(0, res);
    }

    @Test
    public void testLongestIncreasingSubsequence_one_item() {
        MaxSumIncreasingSubsequence o = new MaxSumIncreasingSubsequence();
        int[] ar = {8};
        int res = o.maxSumIncreasingSubsequence(ar);
        Assert.assertEquals(8, res);
    }

    @Test
    public void testLongestIncreasingSubsequence1() {
        MaxSumIncreasingSubsequence o = new MaxSumIncreasingSubsequence();
        int[] ar = {10, 5, 4, 3};
        int res = o.maxSumIncreasingSubsequence(ar);
        Assert.assertEquals(10, res);
    }

    @Test
    public void testLongestIncreasingSubsequence2() {
        MaxSumIncreasingSubsequence o = new MaxSumIncreasingSubsequence();
        int[] ar = {1, 10, 1, 2, 3, 4};
        int res = o.maxSumIncreasingSubsequence(ar);
        Assert.assertEquals(11, res);
    }

    @Test
    public void testLongestIncreasingSubsequence3() {
        MaxSumIncreasingSubsequence o = new MaxSumIncreasingSubsequence();
        int[] ar = {1, 101, 2, 3, 100, 4, 5};
        int res = o.maxSumIncreasingSubsequence(ar);
        Assert.assertEquals(106, res);
    }

}
