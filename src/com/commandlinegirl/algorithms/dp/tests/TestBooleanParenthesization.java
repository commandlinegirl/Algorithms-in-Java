package com.commandlinegirl.algorithms.dp.tests;

import com.commandlinegirl.algorithms.dp.BooleanParenthesization;
import org.junit.Assert;
import org.junit.Test;

public class TestBooleanParenthesization {

    @Test
    public void testBooleanParenthesization_ok1() {
        BooleanParenthesization e = new BooleanParenthesization();
        char[] symbols = "TTFT".toCharArray();
        char[] operators = "|&^".toCharArray();
        int res = e.count(symbols, operators);
        Assert.assertEquals(4, res);
    }

    @Test
    public void testBooleanParenthesization_ok2() {
        BooleanParenthesization e = new BooleanParenthesization();
        char[] symbols = "TFF".toCharArray();
        char[] operators = "|^".toCharArray();
        int res = e.count(symbols, operators);
        Assert.assertEquals(2, res);
    }

}
