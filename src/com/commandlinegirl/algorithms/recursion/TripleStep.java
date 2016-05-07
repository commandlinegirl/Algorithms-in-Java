package com.commandlinegirl.algorithms.recursion;

/*
Cracking the Coding Interview, 6th Edition
Problem 8.1 Triple Step
A child is running up a staircase with n steps and can hop either 1 step, 
2 steps, or 3 steps at a time. Implement a method to count how many possible
ways the child can run up the stairs.
*/
class TripleStep {

    private static int count(int n) {
        if (n < 0)
            return 0;

        int[] cache = new int[Integer.max(n + 1, 3)];
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;

        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }    
        return cache[n]; 
    }    

    public static void main(String... args) {
        assert count(-5) == 0;
        assert count(0) == 1;
        assert count(1) == 1;
        assert count(3) == 4;
        assert count(4) == 7;
        assert count(5) == 13;
        assert count(20) == 121415;
    }    
}    
