package com.commandlinegirl.algorithms.dp;

import com.commandlinegirl.algorithms.utils.Printer;

/**
 * Given a sequence of matrices, find the most efficient way to multiply them.
 */
public class MatrixChainMultiplication {

    private int cost(int[] m, int x, int y, int z) {
        return m[x] * m[y] * m[z];
    }

    private int multiplicationOrderRec(int m[], int i, int j, int[][] cache) {
        if (i == j)
            return 0;
        if (cache[i][j] > 0)
            return cache[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++)
            min = Math.min(min, multiplicationOrderRec(m, i, k) + multiplicationOrderRec(m, k + 1, j) + cost(m, i - 1, k, j));
        cache[i][j] = min;
        return min;
    }

    /**
     * Finds the minimum number of multiplications depending on parentesization.
     * @param m sequence of matrix dimensions where matrix A has dimenstions [i - 1, i]
     * @param s 2nd element of the array (indicates first matrix)
     * @param e last element of the array (indicates # of matrices)
     * @return
     */
    public int multiplicationOrderRec(int m[], int s, int e) {
        int[][] cache =  new int[e+1][e+1];
        for (int i = 0; i <= e; i++) {
            for (int j = 0; j <= e; j++) {
                cache[i][j] = -1;
            }
        }
        return multiplicationOrderRec(m, s, e, cache);
    }

    /**
     * Finds the minimum number of multiplications depending on parentesization.
     * @param m sequence of matrix dimensions where matrix A has dimenstions [i - 1, i]
     * @return
     */
    public int multiplicationOrderTab(int m[]) {
        int n = m.length;
        int[][] t =  new int[n][n];

        for (int i = 1; i < n; i++)
            t[i][i] = 0;

        for (int sublen = 2; sublen < n; sublen++) {
            for (int i = 1; i < n - sublen + 1; i++) {
                int j = i + sublen - 1;
                t[i][j] = Integer.MAX_VALUE;
                // In each iteration matrices i through j are multiplied
                for (int k = i; k < j; k++) {
                    int cost = t[i][k] + t[k+1][j] + cost(m, i - 1, k, j);
                    t[i][j] = Math.min(t[i][j], cost);
                }
            }
        }
        new Printer().printMatrix(t);
        return t[1][n - 1];
    }

}
