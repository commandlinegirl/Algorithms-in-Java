package com.commandlinegirl.algorithms.gameoflife;

import com.commandlinegirl.algorithms.utils.Printer;

/**
 * Create a game of life automaton.
 */
public class GameOfLife {

    /**
     * Returns the next grid based on the following rules (Wikipedia):
     * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
     * Any live cell with two or three live neighbors lives on to the next generation.
     * Any live cell with more than three live neighbors dies, as if by over-population..
     * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     * @param board
     * @return
     */
    public int[][] gameOfLife(int[][] board) {
        if (board == null || board[0].length == 0)
            return board;

        int m = board.length;
        int n = board[0].length;
        int[][] newGrid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = countN(board, i, j, m, n);
                if (c == 3 || c == 2 && board[i][j] == 1)
                    newGrid[i][j] = 1;
            }
        }
        return newGrid;
    }

    private int countN(int[][] g, int i, int j, int m, int n) {
        int ret = 0;

        if (i > 0 && j > 0)
            ret += g[i - 1][j - 1];
        if (i > 0)
            ret += g[i - 1][j];
        if (i > 0 && j < n - 1)
            ret += g[i - 1][j + 1];

        if (j > 0)
            ret += g[i][j - 1];
        if (j < n - 1)
            ret += g[i][j + 1];

        if (i < m - 1 && j > 0)
            ret += g[i + 1][j - 1];
        if (i < m - 1)
            ret += g[i + 1][j];
        if (i < m - 1 && j < n - 1)
            ret += g[i + 1][j + 1];

        return ret;
    }

    public static void main(String... args) {
        GameOfLife gol = new GameOfLife();
        int[][] board = new int[][]{{1,0,0}, {0,0,1}, {1,1,1}};
        int[][] nextG = gol.gameOfLife(board);
        System.out.println("Prev:");
        Printer.printMatrix(board);
        System.out.println("Next:");
        Printer.printMatrix(nextG);
    }
}
