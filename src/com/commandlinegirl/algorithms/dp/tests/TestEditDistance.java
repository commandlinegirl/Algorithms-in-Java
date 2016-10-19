package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.EditDistance;
import org.junit.Assert;
import org.junit.Test;

public class TestEditDistance {

    @Test
    public void testKnapsackTab_ok1() {
        EditDistance e = new EditDistance();
        int res = e.minEditDistanceTab("abcdef", "azced");
        Assert.assertEquals(3, res);
    }

    @Test
    public void testKnapsackRec_ok1() {
        EditDistance e = new EditDistance();
        int res = e.minEditDistanceRec("abcdef", "azced");
        Assert.assertEquals(3, res);
    }

    @Test
    public void testKnapsackTab_ok2() {
        EditDistance e = new EditDistance();
        int res = e.minEditDistanceTab("crow", "candy");
        Assert.assertEquals(4, res);
    }

    @Test
    public void testKnapsackRec_ok2() {
        EditDistance e = new EditDistance();
        int res = e.minEditDistanceRec("crow", "candy");
        Assert.assertEquals(4, res);
    }

    @Test
    public void testKnapsackTab_empty() {
        EditDistance e = new EditDistance();
        int res = e.minEditDistanceTab("", "candy");
        Assert.assertEquals(5, res);
    }

    @Test
    public void testKnapsackRec_empty() {
        EditDistance e = new EditDistance();
        int res = e.minEditDistanceRec("", "candy");
        Assert.assertEquals(5, res);
    }
}
