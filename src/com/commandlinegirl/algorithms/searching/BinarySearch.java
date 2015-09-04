package com.commandlinegirl.algorithms.searching;

import java.util.List;

public class BinarySearch {

    public static int binarySearch(List<Integer> li, int key) {
        int low = 0;
        int high = li.size() - 1;
        
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = li.get(mid);
            if (key < midVal) {
                high = mid - 1;
            } else if (key > midVal) {
                low = mid + 1;
            } else {
                return mid; 
            }
        }
        return -1;
    }

}
