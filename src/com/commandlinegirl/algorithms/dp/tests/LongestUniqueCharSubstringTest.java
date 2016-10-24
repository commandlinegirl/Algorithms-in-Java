package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.LongestUniqueCharSubstring;
import org.junit.Assert;
import org.junit.Test;

public class LongestUniqueCharSubstringTest {

    @Test
    public void testLongestUniqueSubstringRec1() {
        LongestUniqueCharSubstring lps = new LongestUniqueCharSubstring();
        int res = lps.longestUniqueSubstringRec("ABDEFGABEF");
        Assert.assertEquals(6, res);
    }

    @Test
    public void testLongestUniqueSubstringRec2() {
        LongestUniqueCharSubstring lps = new LongestUniqueCharSubstring();
        int res = lps.longestUniqueSubstringRec("BBBB");
        Assert.assertEquals(1, res);
    }

    @Test
    public void testLongestUniqueSubstringRec3() {
        LongestUniqueCharSubstring lps = new LongestUniqueCharSubstring();
        int res = lps.longestUniqueSubstringRec("ABBCDGHIABBCD");
        Assert.assertEquals(7, res);
    }

}
