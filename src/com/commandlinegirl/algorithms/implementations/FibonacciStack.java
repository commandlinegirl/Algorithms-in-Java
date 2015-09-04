package com.commandlinegirl.algorithms.implementations;

import java.math.BigInteger;
import java.util.Stack;

/* Iterative implementation of a Fibonacci sequence generator 
 * with the use of a stack.
 */
public class FibonacciStack {

    public static BigInteger fibonacciIterative(int n)  {    
        Stack<BigInteger> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            if (i < 2) {
                stack.push(new BigInteger(String.valueOf(i)));
                continue;
            }
            BigInteger pop_1 = stack.pop();
            BigInteger pop_2 = stack.pop();
            BigInteger sum = pop_1.add(pop_2);
            stack.push(pop_1);
            stack.push(sum);
        }
        return stack.pop();
    }
}
