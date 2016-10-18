package com.commandlinegirl.algorithms.dp;

/**
 * Dynamic programming solution to the partition problem.
 */
public class PartitionProblem {

    public boolean partition(int[] s) {
        if (s == null)
            throw new IllegalArgumentException("null input array");
        int n = s.length;
        int sum = getSum(s);
        if (sum % 2 != 0)
            return false;
        int halfSum = sum >> 1;

        // p[i][j] is true if there is a subset of {x(1), .., x(j)} that sums up to i, false otherwise
        boolean[][] p = new boolean[halfSum + 1][n + 1];

        //initialize top row of p to true
        for (int i = 0; i <= n; i++)
            p[0][i] = true;

        //initialize first column of p to false (except for p[0][0])
        for (int i = 1; i <= halfSum; i++)
            p[i][0] = false;

        for (int i = 1; i <= halfSum; i++) {
            for (int j = 1; j <= n; j++) {
                p[i][j] = p[i][j-1];
                if (i >= s[j-1])
                    // check also if there is a subset of {x(1), .., x(j-1)} that sums to i − xj,
                    // since x(j) + that subset's sum equal i.
                    p[i][j] = p[i][j - 1] || p[i - s[j - 1]][j - 1];
            }
        }

        // p[halfSum][n] is true iff there exists a subset that sums to halfSum
        return p[halfSum][n];
    }

    /***
     * Returns a sum of elements in the array.
     */
    private int getSum(int[] s) {
        int ret = 0;
        for (int i : s) {
            ret += i;
        }
        return ret;
    }

}
