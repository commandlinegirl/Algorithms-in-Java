package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.LongestPalindromicSubstring;
import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstringTest {

    @Test
    public void testLpSubstring_true() {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        int res = lps.lpSubstring("XBAABACBAD");
        Assert.assertEquals(4, res);
    }

    @Test
    public void testLpSubstring_empty() {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        int res = lps.lpSubstring("");
        Assert.assertEquals(0, res);
    }

    @Test
    public void testLpSubstring_one_element() {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        int res = lps.lpSubstring("1");
        Assert.assertEquals(1, res);
    }

    @Test
    public void testLpSubstring_distinct_chars() {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        int res = lps.lpSubstring("abcdef");
        Assert.assertEquals(1, res);
    }

    @Test
    public void testLpSubstring_full_palindrome() {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        int res = lps.lpSubstring("xmadamx");
        Assert.assertEquals(7, res);
    }
}
