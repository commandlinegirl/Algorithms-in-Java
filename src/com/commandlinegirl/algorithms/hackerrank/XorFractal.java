package com.commandlinegirl.algorithms.hackerrank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Suboptimal solution to the Week of Code 24 at hackerrank.com
 * https://www.hackerrank.com/contests/w24/challenges/xor-matrix
 */
public class XorFractal {
    /*
     * Cyclic input row.
     */
    private static class Input {
        private int values[];
        public Input(int[] values) {
            this.values = values;
        }
        public int get(long i) {
            return values[(int) (i % (long) values.length)];
        }
    }

    /*
     * Pascal triangle modulo 2. Fractal! Note: scale is a power of 2.
     */
    private static HashMap<Long, HashMap<Long, Integer>> cache = new HashMap<>();

    private static int getPascalInternal(long scale, long row, long col) {
        if (row >= scale) throw new IllegalArgumentException("invalid fractal row");
        if (col >= scale) throw new IllegalArgumentException("invalid fractal col");
        if (cache.containsKey(row) && cache.get(row).containsKey(col)) {
            return cache.get(row).get(col);
        }
        if (scale == 1) return 1;
        long half = scale >> 1;
        if (row < half && col >= half) return 0;
        int r = getPascalInternal(half, row % half, col % half);
        if (!cache.containsKey(row)) {
            cache.put(row, new HashMap<>());
        }
        cache.get(row).put(col, r);
        return r;
    }

    private static int getPascal(long row, long col) {
       return getPascalInternal(nextPowerOfTwo(row), row, col);
    }

    private static long nextPowerOfTwo(long i) {
        long x = i;
        int count = 0;
        while (x != 0) {
            x >>= 1;
            count++;
        }
        long ret = 1;
        ret <<= count;
        return ret;
    }

    private static int[] precomputeFilter(long row, int col_count) {
        int[] r = new int[col_count];
        for (long c = 0; c <= row; c++) {
            int p = (int) (c % (long) col_count);
            r[p] ^= getPascal(row, c);
        }
        return r;
    }

    private static int computeOutput(Input input, int[] filter, long col) {
        int r = 0;
        for (int p = 0; p < filter.length; p++) {
            r ^= (filter[p] * input.get(col+p));
        }
        return r;
    }

    private static int[] computeOutputRow(Input input, long row, int col_count) {
        int[] r = new int[col_count];
        int[] filter = precomputeFilter(row, col_count);
        for (int i = 0; i < col_count; i++) {
            r[i] = computeOutput(input, filter, i);
        }
        return r;
    }

    private static void printArray(int[] ar) {
        for (int i : ar) {
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

        Input input = new Input(ar);
        printArray(computeOutputRow(input, m - 1, n));

    }
}
