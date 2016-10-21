package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.PalindromeMinCut;
import org.junit.Assert;
import org.junit.Test;

public class PalindromeMinCutTest {

    @Test
    public void testMinCutsRec_ok1() {
        PalindromeMinCut e = new PalindromeMinCut();
        int res = e.minCutsRec("ababbbabbababa");
        Assert.assertEquals(3, res);
    }

    @Test
    public void testMinCutsTab_ok1() {
        PalindromeMinCut e = new PalindromeMinCut();
        int res = e.minCutsTab("ababbbabbababa");
        Assert.assertEquals(3, res);
    }

}
