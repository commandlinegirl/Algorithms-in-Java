package com.commandlinegirl.algorithms.strings;

import java.util.*;

/**
 * Write a method to evaluate a mathematical reverse polish notation expression.
 * The expression is an array of strings. You can assume the order or tokens in the array
 * is correct.
 */
public class ReversePolishNotation {

    private static final Set<String> operands = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    /***
     * evaluates an array of strings in reverse polish notation
     * supported operand tokens: "+", "-", "*", "/"
     * number tokens: must be decimal integers from -1000 to 1000
    */
    public double evaluateRpnStringArray(String[] tokens) {
        if (tokens == null)
            throw new IllegalArgumentException("tokens must not be null");
        if (tokens.length == 0)
            throw new IllegalArgumentException("tokens must not be empty");

        Stack<Double> s = new Stack<>();
        for(String str : tokens) {
            if (isNumber(str)) {
                s.add(toNumber(str));
            }
            else {
                Double b = s.pop();
                Double a = s.pop();
                Double x = operation(a, b, str);
                s.add(x);
            }
        }

        return s.pop();
    }

    private Double operation(Double a, Double b, String type) {
        switch (type) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0)
                    throw new ArithmeticException("divide by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("operand not supported: " + type);
        }
    }

    private Double toNumber(String str) {
        if (str.startsWith("-"))
            return - Double.parseDouble(str.substring(1));
        return Double.parseDouble(str);
    }

    private boolean isNumber(String i) {
        return !(operands.contains(i));
    }

}
