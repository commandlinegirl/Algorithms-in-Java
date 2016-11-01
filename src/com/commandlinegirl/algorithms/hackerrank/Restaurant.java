package com.commandlinegirl.algorithms.hackerrank;

import java.util.Scanner;

/**
 * Solution to https://www.hackerrank.com/challenges/restaurant
 */

public class Restaurant {

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        if (a == 0) return b;

        if (a > b) return gcd(b, a % b);
        else return gcd(a, b % a);
    }

    private static int solve(int l, int b) {
        int gcd = gcd(l, b);
        return l * b / (gcd * gcd);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            int l = in.nextInt();
            int b = in.nextInt();
            System.out.println(solve(l, b));
        }
        in.close();
    }
}