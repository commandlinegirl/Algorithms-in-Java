package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.LongestCommonSubstring;
import com.commandlinegirl.algorithms.dp.LongestIncreasingSubsequence;
import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubstringTest {



    @Test
    public void testLongestCommonSubstringTab_ok() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String a = "reverse";
        String b = "autoreversethis";
        int res = lcs.lcSubstringTab(a, b);
        Assert.assertEquals(7, res);
    }

    @Test
    public void testLongestCommonSubstringTab2_ok() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String a = "reversae";
        String b = "autoreversethis";
        int res = lcs.lcSubstringTab(a, b);
        Assert.assertEquals(6, res);
    }

    @Test
    public void testLongestCommonSubstringTab3_ok() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String a = "ABCDGH";
        String b = "AEDFHR";
        int res = lcs.lcSubstringTab(a, b);
        Assert.assertEquals(1, res);
    }

    @Test
    public void testLongestCommonSubstringTab4_ok() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String a = "AGGTAB";
        String b = "GXTXAYB";
        int res = lcs.lcSubstringTab(a, b);
        Assert.assertEquals(1, res);
    }

    @Test
    public void testLongestCommonSubstringTab_empty() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String a = "reverse";
        String b = "";
        int res = lcs.lcSubstringTab(a, b);
        Assert.assertEquals(0, res);
    }

    @Test
    public void testLongestCommonSubstringTab_string() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String a = "reverse";
        String b = "autoreversethis";
        String res = lcs.findLcSubstringTab(a, b);
        Assert.assertEquals("reverse", res);
    }


}