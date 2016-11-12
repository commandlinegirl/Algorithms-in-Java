package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.ReverseString;
import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void testReverseString1_rec() {
        ReverseString e = new ReverseString();
        String res = e.reverseStringRecursive("abcdef");
        Assert.assertEquals("fedcba", res);
    }

    @Test
    public void testReverseString2_rec() {
        ReverseString e = new ReverseString();
        String res = e.reverseStringRecursive("a");
        Assert.assertEquals("a", res);
    }

    @Test
    public void testReverseString3_rec() {
        ReverseString e = new ReverseString();
        String res = e.reverseStringRecursive("");
        Assert.assertEquals("", res);
    }

    @Test
    public void testReverseString1_queue() {
        ReverseString e = new ReverseString();
        String res = e.reverseStringQueue("abcdef");
        Assert.assertEquals("fedcba", res);
    }

    @Test
    public void testReverseString2_queue() {
        ReverseString e = new ReverseString();
        String res = e.reverseStringQueue("a");
        Assert.assertEquals("a", res);
    }

    @Test
    public void testReverseString3_queue() {
        ReverseString e = new ReverseString();
        String res = e.reverseStringQueue("");
        Assert.assertEquals("", res);
    }

}
