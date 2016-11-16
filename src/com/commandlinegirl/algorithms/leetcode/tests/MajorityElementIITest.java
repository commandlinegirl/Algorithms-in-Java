package com.commandlinegirl.algorithms.leetcode.tests;

import com.commandlinegirl.algorithms.leetcode.MajorityElementII;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MajorityElementIITest {

    @Test
    public void testMajorityElement1() {
        MajorityElementII e = new MajorityElementII();
        List<Integer> result = e.majorityElement(new int[]{2, 1, 1, 1, 1, 2, 2, 2, 0, 2});
        Assert.assertEquals(Arrays.asList(2, 1), result);
    }

    @Test
    public void testMajorityElement2() {
        MajorityElementII e = new MajorityElementII();
        List<Integer> result = e.majorityElement(new int[]{4,5,4,4,4,6,6,3,6,6});
        Assert.assertEquals(Arrays.asList(4,6), result);
    }
}

