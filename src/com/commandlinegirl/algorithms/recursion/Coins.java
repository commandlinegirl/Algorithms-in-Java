package com.commandlinegirl.algorithms.recursion;

import java.util.Arrays;

/*
Cracking the Coding Interview, 6th Edition
Problem 8.11 Coins
Given an infinite number of quarters, dimes, nickels and pennies,
write code to calculate the number of ways of representing n cents.
*/
public class Coins {

        public static long count(int[] coins, int n, int index, long[][] cache) {

            System.out.println(Arrays.toString(coins) + " n : " + n + " index: " + index);

            if (n == 0) {
                return 1;
            }
            else if(n < 0){
                return 0;
            }
            else if(index <= 0){
                return 0;
            }

            else if (cache[n][index] > 0) {
                return cache[n][index];
            }

            cache[n][index] = count(coins, n, index - 1, cache) + count(coins, n - coins[index - 1], index, cache);
            return cache[n][index];
        }


        public static long count(int[] li, int n) {
            long[][] cache = new long[n + 1][li.length];
            for (long[] i : cache )
                Arrays.fill(i, -1l);
            return count(li, n, li.length - 1, cache);
        }


    public static void main(String... args) {
        int[] coins = {25, 10, 5, 1};
        System.out.println(count(coins, 98));
    }
}
