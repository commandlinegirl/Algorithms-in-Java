package com.commandlinegirl.algorithmsjava.sorting;

/* 
 * Quicksort implementation in place. 
 */
public class Quicksort implements Sort {

    private void swap(int[] ar, int a, int b) {
        if (a >= ar.length || b >= ar.length || a < 0 || b < 0) {
            throw new IllegalArgumentException("Incorrect array index");
        }
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }

    private int partition(int[] ar, int lo, int hi) {
        if (lo >= ar.length || hi >= ar.length || lo < 0 || hi < 0) {
            throw new IllegalArgumentException("Incorrect array index");
        }
        int p = ar[hi]; 
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (ar[j] <= p) {
                swap(ar, i, j);
                i++;  
            }
        }
        swap(ar, i, hi);
        return i;
    }
    
    private void quickSort(int[] ar, int lo, int hi) {
        if (lo < hi) {
            int p = partition(ar, lo, hi);
            quickSort(ar, lo, p - 1);
            quickSort(ar, p + 1, hi);
            
        }
    }

    @Override
    public void sort(int[] ar) {
        if (ar == null) {
            return;
        }
        quickSort(ar, 0, ar.length - 1);
    }

}
