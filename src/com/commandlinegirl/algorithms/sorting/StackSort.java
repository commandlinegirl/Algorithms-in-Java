package com.commandlinegirl.algorithms.sorting;

import java.util.Stack;

/**
 * Write a program to sort a stack such that the smallest items are on the top.
 * You may use an additional temporary stack but you may not copy the elements into
 * any other data structure (such as an array).
 * The challenge comes from Cracking the Coding Interview by Gayle Laakmann McDowell.
 */
public class StackSort {

    public Stack<Integer> sort(Stack<Integer> in) {
        Stack<Integer> sorted = new Stack<>();
        Integer tmp;
        while (!in.isEmpty()) {
            tmp = in.pop();
            while (!sorted.isEmpty() && tmp > sorted.peek()) {
                in.push(sorted.pop());
            }
            sorted.push(tmp);
        }

        return sorted;
    }

}
