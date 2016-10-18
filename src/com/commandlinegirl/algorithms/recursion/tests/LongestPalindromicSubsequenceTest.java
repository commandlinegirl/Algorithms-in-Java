package com.commandlinegirl.algorithms.recursion.tests;

import com.commandlinegirl.algorithms.recursion.LongestPalindromicSubsequence;
import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubsequenceTest {

    @Test
    public void testPalindromicSubsequence_true() {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        int res = lps.lps("ABCBAD");
        Assert.assertEquals(5, res);
    }


}
