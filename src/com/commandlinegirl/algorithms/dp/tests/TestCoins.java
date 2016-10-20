package com.commandlinegirl.algorithms.dp.tests;


import com.commandlinegirl.algorithms.dp.Coins;
import org.junit.Assert;
import org.junit.Test;

public class TestCoins {

    @Test
    public void testTotalCoinsRec_ok1() {
        Coins e = new Coins();
        int res = e.totalCoinsRec(new int[]{1, 2, 3}, 3, 5);
        Assert.assertEquals(5, res);
    }

    @Test
    public void testTotalCoinsTab_ok1() {
        Coins e = new Coins();
        int res = e.totalCoinsTab2(new int[]{1, 2, 3}, 5);
        Assert.assertEquals(5, res);
    }
}
