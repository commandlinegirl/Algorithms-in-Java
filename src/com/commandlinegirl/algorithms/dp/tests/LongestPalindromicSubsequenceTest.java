package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.LongestPalindromicSubsequence;
import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubsequenceTest {

    @Test
    public void testPalindromicSubsequence_true() {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        int res = lps.lps("ABCDBAD");
        Assert.assertEquals(5, res);
    }

    @Test
    public void testPalindromicSubsequenceRec_true() {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        int res = lps.lpsRec("ABCDBAD", 0, 5);
        Assert.assertEquals(5, res);
    }
}
