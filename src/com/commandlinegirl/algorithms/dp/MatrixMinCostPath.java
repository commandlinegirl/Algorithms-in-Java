package com.commandlinegirl.algorithms.dp;

import com.commandlinegirl.algorithms.utils.Printer;

import java.util.ArrayList;
import java.util.List;

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
     * @param a cost matrix
     * @return
     */
    public int minPathSum(List<List<Integer>> a) {
        if (a == null || a.size() == 0) {
            return 0;
        }
        int m = a.size() - 1;
        int n = a.get(0).size() - 1;
        int[][] p = new int[m + 1][n + 1];

        p[0][0] = a.get(0).get(0);

        for (int j = 1; j <= n; j++) {
            p[0][j] = p[0][j - 1] + a.get(0).get(j);
        }

        for (int i = 1; i <= m; i++) {
            p[i][0] = p[i - 1][0] + a.get(i).get(0);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                p[i][j] = a.get(i).get(j) + Math.min(p[i - 1][j], p[i][j - 1]);
            }
        }
        return p[m][n];
    }

    private int min(int i, int j, int k) {
        return Math.min(i, Math.min(j, k));
    }

}
