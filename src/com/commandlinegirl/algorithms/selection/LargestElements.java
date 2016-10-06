package com.commandlinegirl.algorithms.selection;

/**
 * Give an efficient algorithm to find the second-largest key among n keys.
 * Source: http://www.algorist.com/algowiki/index.php/Sorting-searching-TADM2E
 **/
public class LargestElements {

    public int findSecondLargest(int[] ar) {
        int max1 = -1;
        int max2 = -1;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > max1) {
                max2 = max1;
                max1 = ar[i];
            }
        }
        return max2;
    }
}
