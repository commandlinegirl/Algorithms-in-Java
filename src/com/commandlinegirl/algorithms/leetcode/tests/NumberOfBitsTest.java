package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.NumberOfBits;
import org.junit.Assert;
import org.junit.Test;

public class NumberOfBitsTest {

    @Test
    public void testHammingWeight1() {
        NumberOfBits e = new NumberOfBits();
        Assert.assertEquals(2, e.hammingWeight(10));
    }

    @Test
    public void testHammingWeight2() {
        NumberOfBits e = new NumberOfBits();
        Assert.assertEquals(1, e.hammingWeight(1));
    }

    @Test
    public void testHammingWeight3() {
        NumberOfBits e = new NumberOfBits();
        Assert.assertEquals(0, e.hammingWeight(0));
    }

    @Test
    public void testHammingWeight4() {
        NumberOfBits e = new NumberOfBits();
        Assert.assertEquals(31, e.hammingWeight((int) Math.pow(2.0, 31.0)));
    }

    @Test
    public void testHammingWeight5() {
        NumberOfBits e = new NumberOfBits();
        Assert.assertEquals(1, e.hammingWeight(000010));
    }

    @Test
    public void testHammingWeight6() {
        NumberOfBits e = new NumberOfBits();
        Assert.assertEquals(4, e.hammingWeight(15));
    }

    @Test
    public void testHammingWeight7() {
        NumberOfBits e = new NumberOfBits();
        Assert.assertEquals(3, e.hammingWeight(11));
    }

    @Test
    public void testHammingWeight8() {
        NumberOfBits e = new NumberOfBits();
        Assert.assertEquals(31, e.hammingWeight(Integer.MAX_VALUE));
    }

    @Test
    public void testHammingWeight9() {
        NumberOfBits e = new NumberOfBits();
        Assert.assertEquals(1, e.hammingWeight(Integer.MIN_VALUE));
    }
}
