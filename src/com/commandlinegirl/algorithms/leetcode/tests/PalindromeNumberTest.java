package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.PalindromeNumber;
import org.junit.Assert;
import org.junit.Test;

public class PalindromeNumberTest {

    @Test
    public void testPalindromeNumber1() {
        PalindromeNumber e = new PalindromeNumber();
        Assert.assertTrue(e.isPalindrome(202));
    }

    @Test
    public void testPalindromeNumber2() {
        PalindromeNumber e = new PalindromeNumber();
        Assert.assertTrue(e.isPalindrome(1));
    }
    @Test
    public void testPalindromeNumber3() {
        PalindromeNumber e = new PalindromeNumber();
        Assert.assertTrue(e.isPalindrome(0));
    }

    @Test
    public void testPalindromeNumber4() {
        PalindromeNumber e = new PalindromeNumber();
        Assert.assertTrue(e.isPalindrome(02));
    }

    @Test
    public void testPalindromeNumber5() {
        PalindromeNumber e = new PalindromeNumber();
        Assert.assertTrue(e.isPalindrome(131));
    }

    @Test
    public void testPalindromeNumber6() {
        PalindromeNumber e = new PalindromeNumber();
        Assert.assertTrue(e.isPalindrome(12321));
    }

    @Test
    public void testPalindromeNumber7() {
        PalindromeNumber e = new PalindromeNumber();
        Assert.assertFalse(e.isPalindrome(130));
    }

}
