package com.commandlinegirl.algorithms.hackerrank;

import java.util.Scanner;

/**
 * Week of code 24
 * https://www.hackerrank.com/contests/w24/challenges/happy-ladybugs
 */
public class HappyLadybugs {

    private static final int UNDERSCORE = 95 - 65;

    private static boolean solve(String s) {
        int[] counts = new int[31];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = 0;
        }

        char[] chars = s.toCharArray();
        int last = -1;
        int changes = 0;
        for (char c : chars) {
            int intv = (int) c - 65;
            counts[intv]++;
            if (last != intv && intv != UNDERSCORE) {
                changes++;
                last = intv;
            }
        }

        int distinctChars = 0;
        boolean existsLonely = false;
        for (int j = 0; j < counts.length; j++) {
            if (counts[j] == 1 && j != UNDERSCORE)
                existsLonely = true;
            if (counts[j] > 0) {
                distinctChars++;
            }
        }

        if (existsLonely || (counts[UNDERSCORE] == 0 && changes != distinctChars)) {
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            int n = in.nextInt();
            String b = in.next();
            boolean possible = solve(b);
            String result = possible ? "YES" : "NO";
            System.out.println(result);
        }
    }
}
