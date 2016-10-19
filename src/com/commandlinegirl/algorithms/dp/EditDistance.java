package com.commandlinegirl.algorithms.dp;

public class EditDistance {

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    private int minEditDistanceRecHelp(String a, String b, int m, int n, int[][] cache) {


        if (n == 0) {
            cache[m][n] = 0;
            return m;
        }
        if (m == 0) {

            return n;
        }

        if (cache[m][n] > 0)
            return cache[m][n];

        int ans;
        if (a.charAt(m - 1) == b.charAt(n - 1))
            ans = minEditDistanceRecHelp(a, b, m - 1, n - 1, cache);  // MATCH
        else
            ans = 1 + min(
                    minEditDistanceRecHelp(a, b, m, n -1, cache),      // DELETE
                    minEditDistanceRecHelp(a, b, m - 1, n - 1, cache), // REPLACE
                    minEditDistanceRecHelp(a, b, m - 1, n, cache)      // INSERT
            );
        cache[m][n] = ans;
        return ans;
    }

    /***
     * Returns the minimum number of edits required to convert str a to str b
     * Memoized recursive dp solution
     */
    public int minEditDistanceRec(String a, String b) {
        int[][] cache =  new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                cache[i][j] = -1;
            }
        }
        return minEditDistanceRecHelp(a, b, a.length(), b.length(), cache);
    }

    private int[][] editDistanceMatrix(String a, String b) {
        int[][] m = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0)
                    m[i][j] = j;
                else if (j == 0)
                    m[i][j] = i;
                else if (a.charAt(i - 1) == b.charAt(j - 1))
                    m[i][j] = m[i - 1][j - 1];
                else
                    m[i][j] = 1 + min(m[i][j - 1], m[i - 1][j - 1], m[i - 1][j]);
            }
        }
        return m;
    }

    /***
     * Returns the minimum number of edits required to convert str a to str b
     * Bottom-up dp solution
     */
    public int minEditDistanceTab(String a, String b) {
        if (a == null || b == null)
            throw new IllegalArgumentException("null string");
        int[][] editMatrix = editDistanceMatrix(a, b);
        return editMatrix[a.length()][b.length()];
    }

//    /***
//     * Returns the edits needed to convert str a to str b in a minumum number of steps.
//     */
//    public Collection<Edit> minimumEdits(String a, String b) {
//        if (a == null || b == null)
//            throw new IllegalArgumentException("null string");
//        int[][] editMatrix = editDistanceMatrix(a, b);
//        return backtrace(editMatrix, a, b, a.length(), b.length());
//    }

    public static class Edit {
        char editedChar;
        EditType type;

        public Edit(char editedChar, EditType type) {
            this.editedChar = editedChar;
            this.type = type;
        }
    }

    enum EditType {
        MATCH,
        DELETE,
        INSERT,
        REPLACE,
    }
}
