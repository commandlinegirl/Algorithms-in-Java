package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.MajorityElement;
import org.junit.Assert;
import org.junit.Test;

public class MajorityElementTest {

    @Test
    public void testMajorityElement1() {
        MajorityElement e = new MajorityElement();
        int result = e.majorityElement(new int[]{2, 1, 2, 0, 2});
        Assert.assertEquals(2, result);
    }
    @Test
    public void testMajorityElement2() {
        MajorityElement e = new MajorityElement();
        int result = e.majorityElement(new int[]{1, 2});
        Assert.assertEquals(-1, result);
    }
}

