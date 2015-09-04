package com.commandlinegirl.algorithms.hackerrank;

import java.util.Scanner;

/*
 * Solution to hackerrank.com problem:
 * https://www.hackerrank.com/challenges/chocolate-feast
 */
public class ModuloChocolate {

	/* Main algorithm*/
    private static int solve(int n, int c, int m) {
        int result = n / c;
        int total_rest = result;
        
        while(total_rest >= m) {
            int div = total_rest / m;
            int mod = total_rest % m;
            total_rest = div + mod;
            result += div;
        }
        return result;
    }

    public static void main(String[] args) {    	
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        in.close();
    }
}
