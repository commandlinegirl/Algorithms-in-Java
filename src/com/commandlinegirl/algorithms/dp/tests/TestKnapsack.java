package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.Knapsack;
import org.junit.Assert;
import org.junit.Test;

public class TestKnapsack {

    @Test
    public void testKnapsackTab_ok1() {
        Knapsack ks = new Knapsack();
        int[] val = {4,4,3,2};
        int[] wt = {2,3,4,3};
        int totalWt = 6;
        int res = ks.knapSackTab(totalWt, wt, val);
        Assert.assertEquals(8, res);
    }

    @Test
    public void testKnapsackTab_ok2() {
        Knapsack ks = new Knapsack();
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int totalWt = 50;
        int res = ks.knapSackTab(totalWt, wt, val);
        Assert.assertEquals(220, res);
    }

    @Test
    public void testKnapsackTab_ok3() {
        Knapsack ks = new Knapsack();
        int wt[] = new int[]{1,3,4,5};
        int val[] = new int[]{1,4,5,7};
        int totalWt = 7;
        int res = ks.knapSackTab(totalWt, wt, val);
        Assert.assertEquals(9, res);
    }

    @Test
    public void testKnapsackTab_ok4() {
        Knapsack ks = new Knapsack();
        int val[] = new int[]{10,20,30};
        int wt[] = new int[]{1,1,1};
        int totalWt = 2;
        int res = ks.knapSackTab(totalWt, wt, val);
        Assert.assertEquals(50, res);
    }

    @Test
    public void testKnapsackTab_ok5() {
        Knapsack ks = new Knapsack();
        int val[] = new int[]{5,3,4};
        int wt[] = new int[]{3,2,1};
        int totalWt = 5;
        int res = ks.knapSackTab(totalWt, wt, val);
        Assert.assertEquals(9, res);
    }

    @Test
    public void testKnapsackRec_ok1() {
        Knapsack ks = new Knapsack();
        int[] val = {4,4,3,2};
        int[] wt = {2,3,4,3};
        int totalWt = 6;
        int res = ks.knapSackRec(totalWt, wt, val);
        Assert.assertEquals(8, res);
    }

    @Test
    public void testKnapsackRec_ok2() {
        Knapsack ks = new Knapsack();
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int totalWt = 50;
        int res = ks.knapSackRec(totalWt, wt, val);
        Assert.assertEquals(220, res);
    }

    @Test
    public void testKnapsackRec_ok3() {
        Knapsack ks = new Knapsack();
        int wt[] = new int[]{1,3,4,5};
        int val[] = new int[]{1,4,5,7};
        int totalWt = 7;
        int res = ks.knapSackRec(totalWt, wt, val);
        Assert.assertEquals(9, res);
    }

    @Test
    public void testKnapsackRec_ok4() {
        Knapsack ks = new Knapsack();
        int val[] = new int[]{10,20,30};
        int wt[] = new int[]{1,1,1};
        int totalWt = 2;
        int res = ks.knapSackRec(totalWt, wt, val);
        Assert.assertEquals(50, res);
    }

    @Test
    public void testKnapsackRec_ok5() {
        Knapsack ks = new Knapsack();
        int val[] = new int[]{5,3,4};
        int wt[] = new int[]{3,2,1};
        int totalWt = 5;
        int res = ks.knapSackRec(totalWt, wt, val);
        Assert.assertEquals(9, res);
    }
}
