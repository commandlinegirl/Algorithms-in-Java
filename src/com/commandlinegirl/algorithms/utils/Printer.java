package com.commandlinegirl.algorithms.utils;

public class Printer {


    public static void printMatrix(int[][] p) {
        if (p == null)
            throw new IllegalArgumentException("empty matrix");

        for (int i=0;i<p.length;i++) {
            for(int j=0;j<p.length;j++)
                System.out.format("%4d", p[i][j]);
            System.out.println("");
        }
    }

    public static void printArray(int[] ar) {
        for (int i : ar) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
