package com.commandlinegirl.algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathsInMatrix {

    /**
     * Count all possible paths from top left to bottom right of a matrix (m+1 x n+1).
     * From each cell you can move only to right or down.
     */
    private int countHelp(int m, int n, int[][] cache) {
        if (m == 0 || n == 0)
            return 1;
        if (cache[m][n] > 0)
            return cache[m][n];

        cache[m][n] = countHelp(m - 1, n, cache) + countHelp(m, n - 1, cache);
        return cache[m][n];
    }

    /**
     * Count all possible paths from top left to bottom right of a matrix.
     * From each cell you can move only to right or down.
     */
    public int count(int m, int n) {
        int[][] cache =  new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                cache[i][j] = -1;
            }
        }
        return countHelp(m, n, cache);
    }

    /**
     * Print all possible paths from top left to bottom right of a mXn matrix.
     * From each cell you can move only to right or down.
     */
    private List<List<Integer>> printHelp(int[][] matrix, int m, int n) {
        List<List<Integer>> paths = new ArrayList<>();

        if (m == 0 && n == 0) {
            List<Integer> l = new ArrayList<>();
            l.add(matrix[m][n]);
            paths.add(l);
            return paths;
        }

        if (m == 0) {
            List<List<Integer>> pathsToHereFromLeft = getPathsFrom(matrix, matrix[m][n], m, n - 1);
            return pathsToHereFromLeft;
        }
        if (n == 0) {
            List<List<Integer>> pathsToHereFromTop = getPathsFrom(matrix, matrix[m][n], m - 1, n);
            return pathsToHereFromTop;
        }
        
        List<List<Integer>> pathsToHereFromLeft = getPathsFrom(matrix, matrix[m][n], m, n - 1);
        List<List<Integer>> pathsToHereFromTop = getPathsFrom(matrix, matrix[m][n], m - 1, n);

        pathsToHereFromTop.addAll(pathsToHereFromLeft);
        return pathsToHereFromTop;
    }

    private List<List<Integer>> getPathsFrom(int[][] matrix, int currentVal, int m, int n) {
        List<List<Integer>> pathsToHereFrom = printHelp(matrix, m, n);
        List<List<Integer>> pathsToHereFromNew = new ArrayList<>();
        for (List<Integer> s : pathsToHereFrom) {
            s.add(currentVal);
            pathsToHereFromNew.add(s);
        }
        return pathsToHereFromNew;
    }

    /**
     * Print all possible paths from top left to bottom right of a mXn matrix.
     * From each cell you can move only to right or down.
     */
    public List<List<Integer>> print(int[][] matrix, int m, int n) {
        return printHelp(matrix, m, n);
    }
}
