package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.LongestIncreasingSubsequence;
import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void testLongestIncreasingSubsequence_empty() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] ar = {};
        int res = lis.lisTab(ar);
        Assert.assertEquals(0, res);
    }

    @Test
    public void testLongestIncreasingSubsequence_one_item() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] ar = {8};
        int res = lis.lisTab(ar);
        Assert.assertEquals(1, res);
    }

    @Test
    public void testLongestIncreasingSubsequence1() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] ar = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int res = lis.lisTab(ar);
        Assert.assertEquals(6, res);

    }

    @Test
    public void testLongestIncreasingSubsequence2() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] ar =  { 10, 9, 8, 7, 9, 5, 11, 0 };
        int res = lis.lisTab(ar);
        Assert.assertEquals(3, res);
    }

    @Test
    public void testLongestIncreasingSubsequence3() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] ar = {8, 7, 6, 5, 4, 3};
        int res = lis.lisTab(ar);
        Assert.assertEquals(1, res);
    }


}