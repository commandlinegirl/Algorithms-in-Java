package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.LongestCommonSubstring;
import com.commandlinegirl.algorithms.dp.LongestIncreasingSubsequence;
import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubstringTest {

    @Test
    public void testLongestCommonSubstringRec_ok() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String a = "reverse";
        String b = "autoreversethis";
        int res = lcs.lcSubstringRec(a, b, a.length(), b.length());
        Assert.assertEquals(7, res);
    }

    @Test
    public void testLongestCommonSubstringRec_empty() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String a = "";
        String b = "autoreversethis";
        int res = lcs.lcSubstringRec(a, b, a.length(), b.length());
        Assert.assertEquals(0, res);
    }

    @Test
    public void testLongestCommonSubstringRecMem_ok() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String a = "reverse";
        String b = "autoreversethis";
        int res = lcs.lcSubstringRecMem(a, b);
        Assert.assertEquals(7, res);
    }

    @Test
    public void testLongestCommonSubstringRecMem_empty() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String a = "reverse";
        String b = "";
        int res = lcs.lcSubstringRecMem(a, b);
        Assert.assertEquals(0, res);
    }

    @Test
    public void testLongestCommonSubstringTab_ok() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String a = "reverse";
        String b = "autoreversethis";
        int res = lcs.lcSubstringTab(a, b);
        Assert.assertEquals(7, res);
    }

    @Test
    public void testLongestCommonSubstringTab_empty() {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String a = "reverse";
        String b = "";
        int res = lcs.lcSubstringTab(a, b);
        Assert.assertEquals(0, res);
    }
}