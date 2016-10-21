package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.MatrixChainMultiplication;
import org.junit.Assert;
import org.junit.Test;

public class MatrixChainMultiplicationTest {

    @Test
    public void testMultiplicationOrderRec() {
        MatrixChainMultiplication e = new MatrixChainMultiplication();
        int[] m = {40, 20, 30, 10, 30};
        Assert.assertEquals(26000, e.multiplicationOrderRec(m, 1, m.length - 1));
    }

    @Test
    public void testMultiplicationOrderTab() {
        MatrixChainMultiplication e = new MatrixChainMultiplication();
        int[] m = {40, 20, 30, 10, 30};
        Assert.assertEquals(26000, e.multiplicationOrderTab(m));
    }

    @Test
    public void testMultiplicationOrderRec2() {
        MatrixChainMultiplication e = new MatrixChainMultiplication();
        int[] m = {10, 20, 30};
        Assert.assertEquals(6000, e.multiplicationOrderRec(m, 1, m.length - 1));
    }

    @Test
    public void testMultiplicationOrderTab2() {
        MatrixChainMultiplication e = new MatrixChainMultiplication();
        int[] m = {10, 20, 30};
        Assert.assertEquals(6000, e.multiplicationOrderTab(m));
    }

}
