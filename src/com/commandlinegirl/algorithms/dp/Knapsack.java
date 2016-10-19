package com.commandlinegirl.algorithms.dp;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    public int knapSackRecHelp(int totalWt, int wt[], int val[], int n) {
        if (totalWt == 0 || n == 0)
            return 0;

        if (wt[n - 1] > totalWt)
            return knapSackRecHelp(totalWt, wt, val, n - 1);

        return Math.max(
                // we don't include the item
                knapSackRecHelp(totalWt, wt, val, n - 1),
                // we include the item, which reduces the available weight,
                // and add item's weight to the result (knapsack :))
                val[n - 1] + knapSackRecHelp(totalWt - wt[n - 1], wt, val, n - 1));
    }

    /***
     * Returns the maximum value that can be put in a knapsack of capacity W
     * Recursive solution
     */
    public int knapSackRec(int totalWt, int wt[], int val[]) {
        return knapSackRecHelp(totalWt, wt, val, val.length);
    }

    private int[][] knapSackTabMatrix(int totalWt, int wt[], int val[]) {
        int n = val.length;
        int[][] t = new int[n + 1][totalWt + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= totalWt; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if (wt[i - 1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = Math.max(
                            t[i-1][j], // don't include the item i
                            val[i - 1] + t[i - 1][j - wt[i - 1]]); // include the item i
            }
        }

        return t;
    }

    /***
     * Returns the maximum value that can be put in a knapsack of capacity
     * Tabulated bottom-up solution
     */
    public int knapSackTab(int totalWt, int wt[], int val[]) {
        int[][] t = knapSackTabMatrix(totalWt, wt, val);
        return t[val.length][totalWt];
    }

    /***
     * Tabulated bottom-up solution
     * Returns a list of items that can be put in a knapsack of capacity W
     * so that their value is maxiumum.
     */
    public int[] knapSackItems(int totalWt, int wt[], int val[]) {
        int[][] t = knapSackTabMatrix(totalWt, wt, val);
        List<Integer> ret = new ArrayList<>();

        return t[0];
    }

}
