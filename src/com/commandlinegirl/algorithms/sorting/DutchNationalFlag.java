package com.commandlinegirl.algorithms.sorting;

/**
 * Suppose an array A consists of n elements, each of which is red, white, or blue.
 * We seek to sort the elements so that all the reds come before all the whites, which
 * come before all the blues The only operation permitted on the keys are
 * Examine(A,i) -- report the color of the ith element of A.
 * Swap(A,i,j) -- swap the ith element of A with the jth element.
 * Find a correct and efficient algorithm for red-white-blue sorting. There is a linear-time
 * solution. This is also known as the Dutch national flag problem. The simplest linear time
 * solution performs two passes of the partition operation from Quicksort. The first pass
 * treats the red and white elements as indistinguishable, and separates them from the blue.
 * The second pass is just separates the elements within the red/white sub-array.
 */
public class DutchNationalFlag implements Sort {

    private void swap(int[] ar, int i, int j) {
        if (ar == null || i >= ar.length || j >= ar.length)
            throw new IllegalArgumentException();
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }

    private int examine(int[] ar, int i) {
        if (ar == null || i >= ar.length)
            return -1;
        return ar[i];
    }

    private int partition(int[] ar, int hi, int colorDiff) {
        int i = 0; // next pivot index
        for (int j = 0; j <= hi; j++) {
            if (examine(ar, j) < colorDiff) {
                swap(ar, i, j);
                i++;
            }
        }
        return i;
    }

    @Override
    public void sort(int[] ar) {
        // 2 represents blue, 1 - white, 0 - red
        int p = partition(ar, ar.length - 1, 2);
        partition(ar, p - 1, 1);
    }
}
