package com.commandlinegirl.algorithms.strings.test;

import com.commandlinegirl.algorithms.strings.ReversePolishNotation;
import org.junit.Assert;
import org.junit.Test;

public class ReversePolishNotationTest {

    @Test
    public void testEvaluateRpnString() {
        String[] tokens = {"3", "5", "+", "7", "2", "-", "/"};
        ReversePolishNotation rpn = new ReversePolishNotation();
        Double result = rpn.evaluateRpnStringArray(tokens);
        Assert.assertEquals(1.6, result, 0.001);
    }

    @Test
    public void testEvaluateRpnString_negative() {
        String[] tokens = {"3", "-5", "+"};
        ReversePolishNotation rpn = new ReversePolishNotation();
        Double result = rpn.evaluateRpnStringArray(tokens);
        Assert.assertEquals(-2, result, 0.001);
    }
}

