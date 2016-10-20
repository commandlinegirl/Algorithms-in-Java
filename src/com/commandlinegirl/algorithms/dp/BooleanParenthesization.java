package com.commandlinegirl.algorithms.dp;

/**
 * Given an array of True/False operands and an array of operators, find out the
 * number of ways parenthesis can be used to group these operands such that the result is always true.
 * The complexity of this solution is O(n^3). Since we have N*(N-1)/2 "subexpressions" of length S+1
 * that need to be splitted evaluated S*(N-S) times.
 */
public class BooleanParenthesization {

    public int count(char[] symbols, char[] ops) {
        int n = symbols.length;

        int[][] t = new int[n][n];
        int[][] f = new int[n][n];

        // Base cases: diagonal entries take 1 for T and F
        // in t and f tables, respectively (T evaluates to true
        // and F to false)
        for (int i = 0; i < n; i++) {
            f[i][i] = (symbols[i] == 'F') ? 1 : 0;
            t[i][i] = (symbols[i] == 'T') ? 1 : 0;
        }

        // Evaluate the parenthesizations for all the subexpressions of size S and compute x[i][i+S]
        // for i from 1 to N-S, eg. f[i][i+S], f[i][i+S] for S=1, S=2, etc. There are S ways we
        // can split the expression. We evaluate each split S*(N-S) times.
        for (int S = 2; S <= n; S++) {
            for (int i = 0; i <= n - S; i++) {
                int j = i + S - 1;
                for (int k = i; k < j; k++) { // Break points for subexpressions

                    // Store total[i][k] and total[k+1][j]
                    int tik = t[i][k] + f[i][k];
                    int tkj = t[k + 1][j] + f[k + 1][j];

                    if (ops[k] == '&') {
                        t[i][j] += t[i][k] * t[k + 1][j];
                        f[i][j] += (tik * tkj - t[i][k] * t[k + 1][j]);
                    }
                    if (ops[k] == '|') {
                        f[i][j] += f[i][k] * f[k + 1][j];
                        t[i][j] += (tik * tkj - f[i][k] * f[k + 1][j]);
                    }
                    if (ops[k] == '^') {
                        t[i][j] += f[i][k] * t[k + 1][j] + t[i][k] * f[k + 1][j];
                        f[i][j] += t[i][k] * t[k + 1][j] + f[i][k] * f[k + 1][j];
                    }
                }
            }
        }
        return t[0][n - 1];
    }    

}
