package com.commandlinegirl.algorithms.dp;

import com.commandlinegirl.algorithms.utils.Printer;

public class MatrixMinCostPath {

    /***
     * Min cost path recursive solution without memoization
     * @param matrix cost matrix
     * @param m target index
     * @param n target index
     * @return
     */
    public int minCostPathRec1(int[][] matrix, int m, int n) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if (m == 0 && n == 0)
            return matrix[0][0];
        return matrix[m][n] + min(
                minCostPathRec1(matrix, m - 1, n - 1),
                minCostPathRec1(matrix, m - 1, n),
                minCostPathRec1(matrix, m, n - 1));
    }

    /***
     * Min cost path - another recursive solution without memoization
     * @param matrix cost matrix
     * @param m target index
     * @param n target index
     * @return
     */
    public int minCostPathRec2(int[][] matrix, int m, int n) {
        if (m == 0 && n == 0)
            return matrix[0][0];
        if (m == 0)
            return matrix[m][n] + minCostPathRec2(matrix, m, n - 1);
        if (n == 0)
            return matrix[m][n] + minCostPathRec2(matrix, m - 1, n);
        return matrix[m][n] + min(
                minCostPathRec2(matrix, m - 1, n - 1),
                minCostPathRec2(matrix, m - 1, n),
                minCostPathRec2(matrix, m, n - 1));
    }

    /***
     * Min cost path - table bottom-up solution.
     * @param matrix cost matrix
     * @param m target index
     * @param n target index
     * @return
     */
    public int minCostPathTab(int[][] matrix, int m, int n) {
        int[][] p = new int[m+2][n+2];
        for (int i = 0; i <= m + 1; i++) {
            for (int j = 0; j <= n + 1; j++) {
                if (i == 0 && j == 0)
                    p[0][0] = 0;
                else if (i == 0 || j == 0)
                    p[i][j] = Integer.MAX_VALUE;
                else
                    p[i][j] = matrix[i-1][j-1] + min(p[i-1][j], p[i-1][j-1], p[i][j-1]);
            }
        }
        new Printer().printMatrix(p);
        return p[m + 1][n + 1];
    }

    private int min(int i, int j, int k) {
        return Math.min(i, Math.min(j, k));
    }
}
