package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.LongestUniqueCharSubstring;
import org.junit.Assert;
import org.junit.Test;

public class LongestUniqueCharSubstringTest {

    @Test
    public void testLongestUniqueSubstringRec1() {
        LongestUniqueCharSubstring lps = new LongestUniqueCharSubstring();
        int res = lps.longestUniqueSubstring("ABDEFGABEF");
        Assert.assertEquals(6, res);
    }

    @Test
    public void testLongestUniqueSubstringRec2() {
        LongestUniqueCharSubstring lps = new LongestUniqueCharSubstring();
        int res = lps.longestUniqueSubstring("BBBB");
        Assert.assertEquals(1, res);
    }

    @Test
    public void testLongestUniqueSubstringRec3() {
        LongestUniqueCharSubstring lps = new LongestUniqueCharSubstring();
        int res = lps.longestUniqueSubstring("ABBCDGHIABBCD");
        Assert.assertEquals(7, res);
    }

    @Test
    public void testLongestUniqueSubstringRec4() {
        LongestUniqueCharSubstring lps = new LongestUniqueCharSubstring();
        int res = lps.longestUniqueSubstring("lxhgmywmlalijiypvmrpqpptipcntdygafppgldr");
        Assert.assertEquals(10, res);
    }

    @Test
    public void testLongestUniqueSubstringRec5() {
        LongestUniqueCharSubstring lps = new LongestUniqueCharSubstring();
        int res = lps.longestUniqueSubstring("");
        Assert.assertEquals(0, res);
    }

    @Test
    public void testLongestUniqueSubstringRec6() {
        LongestUniqueCharSubstring lps = new LongestUniqueCharSubstring();
        int res = lps.longestUniqueSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Assert.assertEquals(1, res);
    }

    @Test
    public void testLongestUniqueSubstringRec7() {
        LongestUniqueCharSubstring lps = new LongestUniqueCharSubstring();
        int res = lps.longestUniqueSubstring("aba");
        Assert.assertEquals(2, res);
    }



}
