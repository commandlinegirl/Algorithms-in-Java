package com.commandlinegirl.algorithms.dp;

import java.util.Arrays;

public class Coins {


    /**
     * Returns the total number of ways we can make the change of the amount t using the coins given.
     * Recursive solution.
     * @param coins available coin values
     * @param m coin index
     * @param t total amount
     */
    public int totalCoinsRec(int[] coins, int m, int t) {
        if (t == 0)
            return 1;
        if (t < 0)
            return 0;
        if (m <= 0 && t >= 1)
            return 0;
        return totalCoinsRec(coins, m - 1,  t) // do not include the coin
                + totalCoinsRec(coins, m, t - coins[m - 1]); // include the coin
    }

    /**
     * Returns the minimum number of coins needed to give a change of n.
     * Bottom-up dp solution.
     * @param coins available coin values
     * @param t total amount
     */
    public int totalCoinsTab(int[] coins, int t) {
        int[] tab = new int[t + 1];
        Arrays.fill(tab, 0);
        tab[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= t; j++) {
                tab[j] += tab[j - coins[i]];
            }
        }
        return tab[t];
    }
    
    /**
     * Returns the minimum number of coins needed to give a change of n.
     * Bottom-up dp solution.
     * @param coins available coin values
     * @param t total amount
     */
    public int totalCoinsTab2(int[] coins, int t) {
        int[][] tab = new int[coins.length + 1][t + 1];

        for (int i = 0; i <= coins.length; i++)
            tab[i][0] = 1;
        for (int i = 1; i <= t; i++)
            tab[0][i] = 0;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= t; j++) {
                if (coins[i - 1] <= j)
                    tab[i][j] = tab[i - 1][j] + tab[i][j - coins[i - 1]];
                else
                    tab[i][j] = tab[i - 1][j];
            }
        }
        return tab[coins.length][t];
    }




    /**
     * Returns the minimum number of coins needed to give a change of n.
     * Recursive solution.
     */
    public int minCoinsRec(int[] coins, int n) {
        if (n == 0)
            return 0;
        return 0;
    }

    /**
     * Returns the minimum number of coins needed to give a change of n.
     * Iterative bottom-up dp solution.
     */
    public int minCoinsTab(int[] coins, int n) {
        if (n == 0)
            return 0;
        return 0;
    }

}
