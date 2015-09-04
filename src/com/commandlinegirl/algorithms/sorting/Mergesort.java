package com.commandlinegirl.algorithms.sorting;

/* 
 * Mergesort implementation. 
 */
public class Mergesort implements Sort {

    private void swap(int[] ar, int a, int b) {
        if (a >= ar.length || b >= ar.length || a < 0 || b < 0) {
            throw new IllegalArgumentException("Incorrect array index");
        }
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }

    private int merge(int[] ar, int lo, int hi, int mid) {
        int n1 = mid - lo + 1;
        int n2 = hi - mid;

        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        
    }
    
    public static void mergeSort(int[] ar, int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) >>> 1;
            merge(ar, lo, hi);
            merge(ar, mid + 1, hi);
            merge(ar, lo, mid, hi);
        }
    }

    @Override
    public void sort(int[] ar) {
        if (ar == null) {
            return;
        }
        mergeSort(ar, 0, ar.length - 1);
    }
    
}

