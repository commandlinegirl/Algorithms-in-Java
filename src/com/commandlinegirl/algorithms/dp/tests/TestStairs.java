package com.commandlinegirl.algorithms.dp.tests;


import com.commandlinegirl.algorithms.dp.Stairs;
import org.junit.Assert;
import org.junit.Test;

public class TestStairs {

    @Test
    public void testJumpsTopDown1() {
        Stairs e = new Stairs();
        int res = e.jumpsTopDown(4, 2);
        Assert.assertEquals(5, res);
    }

    @Test
    public void testJumpsTopDown2() {
        Stairs e = new Stairs();
        int res = e.jumpsTopDown(2, 2);
        Assert.assertEquals(2, res);
    }

    @Test
    public void testJumpsTopDown3() {
        Stairs e = new Stairs();
        int res = e.jumpsTopDown(1, 3);
        Assert.assertEquals(1, res);
    }

    @Test
    public void testJumpsBottomUp1() {
        Stairs e = new Stairs();
        int res = e.jumpsBottomUp(4, 2);
        Assert.assertEquals(5, res);
    }

    @Test
    public void testJumpsBottomUp2() {
        Stairs e = new Stairs();
        int res = e.jumpsBottomUp(2, 2);
        Assert.assertEquals(2, res);
    }

    @Test
    public void testJumpsBottomUp3() {
        Stairs e = new Stairs();
        int res = e.jumpsBottomUp(1, 3);
        Assert.assertEquals(1, res);
    }
}
