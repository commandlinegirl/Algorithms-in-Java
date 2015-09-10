package com.commandlinegirl.algorithms.misc.test;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import com.commandlinegirl.algorithms.misc.FibonacciStack;

public class TestFibonacciStack {

    @Test
    public void bigIntegerTestCalcs() {
        assertEquals(FibonacciStack.fibonacciIterative(0), BigInteger.ZERO);
        assertEquals(FibonacciStack.fibonacciIterative(1), BigInteger.ONE);
        assertEquals(FibonacciStack.fibonacciIterative(6), new BigInteger("8"));
        assertEquals(FibonacciStack.fibonacciIterative(300), 
                new BigInteger("222232244629420445529739893461909967206666939096499764990979600"));
    }
}
