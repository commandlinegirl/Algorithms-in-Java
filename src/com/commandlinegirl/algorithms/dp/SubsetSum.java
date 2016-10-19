package com.commandlinegirl.algorithms.dp;

/**
 * Given a set of non-negative integers, and a value k, determine
 * if there is a subset of the given set with sum equal to given k.
 * This is basically an extension of Partition Problem, whose sum is
 * a half of the set length.
 */
public class SubsetSum {

    public boolean isSubsetSum(int[] ar, int sum) {
        int n = ar.length;
        boolean[][] s = new boolean[sum + 1][n + 1];

        // tru for a zero sum
        for (int i = 0; i <= n; i++)
            s[0][i] = true;
        // empty set, non-zero sum
        for (int i = 1; i <= sum; i++)
            s[i][0] = false;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] = s[i][j - 1];
                if (i >= ar[j - 1]) {
                    // check also if there is a subset of {x(1), .., x(j-1)} that sums to i − xj,
                    // since x(j) + that subset's sum equal i.
                    s[i][j] = s[i][j - 1] || s[i - ar[j - 1]][j - 1];
                }
            }
        }

        return s[sum][n];
    }
}
