package com.commandlinegirl.algorithms.strings.test;

import com.commandlinegirl.algorithms.strings.Palindrome;
import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {

    @Test
    public void testIsPalindrome1() {
        boolean res = Palindrome.isPalindrome("aba");
        Assert.assertTrue(res);
    }

    @Test
    public void testIsPalindrome2() {
        boolean res = Palindrome.isPalindrome("aba");
        Assert.assertTrue(res);
    }

    @Test
    public void testIsPalindrome3() {
        boolean res = Palindrome.isPalindrome("abba");
        Assert.assertTrue(res);
    }

    @Test
    public void testIsPalindrome4() {
        boolean res = Palindrome.isPalindrome("");
        Assert.assertTrue(res);
    }

    @Test
    public void testIsPalindrome5() {
        boolean res = Palindrome.isPalindrome("a");
        Assert.assertTrue(res);
    }

    @Test
    public void testIsPalindrome6() {
        boolean res = Palindrome.isPalindrome("ac");
        Assert.assertFalse(res);
    }

    @Test
    public void testIsPalindrome7() {
        boolean res = Palindrome.isPalindrome("acc");
        Assert.assertFalse(res);
    }

}
