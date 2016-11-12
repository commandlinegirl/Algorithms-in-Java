package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.ValidParentheses;
import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesesTest {

    @Test
    public void testReverseString1_rec() {
        ValidParentheses e = new ValidParentheses();
        boolean res = e.isValid("()");
        Assert.assertTrue(res);
    }
}
