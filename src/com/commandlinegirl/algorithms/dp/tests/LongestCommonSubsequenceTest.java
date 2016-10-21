package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.LongestCommonSubsequence;
import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubsequenceTest {

    @Test
    public void testLongestCommonSubsequenceRec_ok() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "123587648";
        String b = "14348";
        int res = lcs.lcSubsequenceRec(a, b, a.length(), b.length());
        Assert.assertEquals(4, res);
    }

    @Test
    public void testLongestCommonSubsequenceRec2_ok() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "reversae";
        String b = "autoreversethis";
        int res = lcs.lcSubsequenceRec(a, b, a.length(), b.length());
        Assert.assertEquals(7, res);
    }

    @Test
    public void testLongestCommonSubsequenceRec3_ok() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "ABCDGH";
        String b = "AEDFHR";
        int res = lcs.lcSubsequenceRec(a, b, a.length(), b.length());
        Assert.assertEquals(3, res);
    }

    @Test
    public void testLongestCommonSubsequenceRec4_ok() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "AGGTAB";
        String b = "GXTXAYB";
        int res = lcs.lcSubsequenceRec(a, b, a.length(), b.length());
        Assert.assertEquals(4, res);
    }

    @Test
    public void testLongestCommonSubsequenceRec_empty() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "";
        String b = "autoreversethis";
        int res = lcs.lcSubsequenceRec(a, b, a.length(), b.length());
        Assert.assertEquals(0, res);
    }

    @Test
    public void testLongestCommonSubsequenceRecMem_ok() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "123587648";
        String b = "14348";
        int res = lcs.lcSubsequenceRec(a, b, a.length(), b.length());
        Assert.assertEquals(4, res);
    }

    @Test
    public void testLongestCommonSubsequenceRecMem_empty() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "reverse";
        String b = "";
        int res = lcs.lcSubsequenceRecMem(a, b);
        Assert.assertEquals(0, res);
    }

    @Test
    public void testLongestCommonSubsequenceRecMem2_ok() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "reversae";
        String b = "autoreversethis";
        int res = lcs.lcSubsequenceRecMem(a, b);
        Assert.assertEquals(7, res);
    }

    @Test
    public void testLongestCommonSubsequenceRecMem3_ok() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "ABCDGH";
        String b = "AEDFHR";
        int res = lcs.lcSubsequenceRecMem(a, b);
        Assert.assertEquals(3, res);
    }

    @Test
    public void testLongestCommonSubsequenceRecMem4_ok() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "AGGTAB";
        String b = "GXTXAYB";
        int res = lcs.lcSubsequenceRecMem(a, b);
        Assert.assertEquals(4, res);
    }


    @Test
    public void testLongestCommonSubsequenceTab_ok() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "reverse";
        String b = "autoreversethis";
        int res = lcs.lcSubsequenceTab(a, b);
        Assert.assertEquals(7, res);
    }

    @Test
    public void testLongestCommonSubsequenceTab2_ok() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "reversae";
        String b = "autoreversethis";
        int res = lcs.lcSubsequenceTab(a, b);
        Assert.assertEquals(7, res);
    }

    @Test
    public void testLongestCommonSubsequenceTab3_ok() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "ABCDGH";
        String b = "AEDFHR";
        int res = lcs.lcSubsequenceTab(a, b);
        Assert.assertEquals(3, res);
    }

    @Test
    public void testLongestCommonSubsequenceTab4_ok() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "AGGTAB";
        String b = "GXTXAYB";
        int res = lcs.lcSubsequenceTab(a, b);
        Assert.assertEquals(4, res);
    }

    @Test
    public void testLongestCommonSubsequenceTab_empty() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String a = "reverse";
        String b = "";
        int res = lcs.lcSubsequenceTab(a, b);
        Assert.assertEquals(0, res);
    }

//    @Test
//    public void testLongestCommonSubsequenceTab_string() {
//        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
//        String a = "reverse";
//        String b = "autoreversethis";
//        String res = lcs.findLcSubsequenceTab(a, b);
//        Assert.assertEquals("reverse", res);
//    }


}