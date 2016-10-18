package com.commandlinegirl.algorithms.hackerrank;

import java.util.Scanner;

/**
 * Optimal solution to the Week of Code 24 at hackerrank.com
 * https://www.hackerrank.com/contests/w24/challenges/xor-matrix
 */
public class XorMatrix {
    /*
     * Cyclic input row.
     */
    private static class Row {
        private int values[];
        public Row(int[] values) {
            this.values = values;
        }
        public int get(long i) {
            return values[(int) (i % (long) values.length)];
        }
    }

    private static long smallerPowerOfTwo(long i) {
        if (i == 0) {
            return 0;
        }
        long x = i;
        int count = 0;
        while (x != 0) {
            x >>= 1;
            count++;
        }
        long ret = 1;
        ret <<= (count - 1);
        return ret;
    }

    private static Row computeOutputRow(Row row, long row_num, int col_count) {
        if (row_num == 0) {
            return row;
        }
        Row newRow = new Row(new int[col_count]);
        long k = smallerPowerOfTwo(row_num);
        row_num -= k;
        for (int i = 0; i < col_count; i++) {
            newRow.values[i] = row.values[i] ^ row.values[(int) ((i + k) % col_count)];
        }
        return computeOutputRow(newRow, row_num, col_count);
    }

    private static void printArray(Row row) {
        for (int i : row.values) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        int[] ar = new int[n];
        for(int i = 0; i < n; i++){
            ar[i] = in.nextInt();
        }
        in.close();

        Row row = new Row(ar);
        printArray(computeOutputRow(row, m - 1, n));

    }
}
