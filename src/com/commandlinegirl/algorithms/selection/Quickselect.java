package com.commandlinegirl.algorithms.selection;

/**
 * Finds the kth smallest element in an unordered array.
 */
public class Quickselect {

    private int quickSelect(int[] ar, int lo, int hi, int k) {
        if (lo == hi)
            return ar[lo];
        int p = partition(ar, lo, hi);

        if (k == p)
            return ar[k];
        if (k < p)
            return quickSelect(ar, lo, p - 1, k);
        else
            return quickSelect(ar, p + 1, hi, k);
    }

    private int partition(int[] ar, int lo, int hi) {
        int pivotValue = ar[hi];
        int pivotIndex = lo;
        for (int j = lo; j < hi; j++) {
            if (ar[j] < pivotValue) {
                swap(ar, pivotIndex, j);
                pivotIndex++;
            }
        }
        swap(ar, pivotIndex, hi); // swap the pivot (the end position) with the current pivot index i
        return pivotIndex;
    }

    private void swap(int[] ar, int a, int b) {
        int tmp = ar[a];
        ar[a] = ar[b];
        ar[b] = tmp;
    }

    public int getKthSmallestElement(int[] ar, int k) {
        if (ar == null | ar.length == 0)
            return -1;
        return quickSelect(ar, 0, ar.length - 1, k);
    }

}
