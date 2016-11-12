package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.AddBinary;
import org.junit.Assert;
import org.junit.Test;

public class AddBinaryTest {

    @Test
    public void testAddBinary() {
        AddBinary e = new AddBinary();
        Assert.assertEquals("100", e.addBinary("11", "1"));
        Assert.assertEquals("0", e.addBinary("0", "0"));
        Assert.assertEquals("100", e.addBinary("10", "10"));
        Assert.assertEquals("1", e.addBinary("0", "00000001"));
        Assert.assertEquals("0", e.addBinary("000000000000", "0000000"));
        Assert.assertEquals("1000000", e.addBinary("111111", "1"));
        Assert.assertEquals("1", e.addBinary("0", "00000001"));
        Assert.assertEquals("1", e.addBinary("0", "00000001"));
        Assert.assertEquals("1", e.addBinary("0", "00000001"));

    }
}
