package com.commandlinegirl.algorithms.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> li = new HashSet<>();
        int a = 0;
        int b = 0;
        while (a < nums1.length && b < nums2.length) {
            if (nums1[a] < nums2[b]) {
                a++;
            }
            else if (nums1[a] > nums2[b]) {
                b++;
            }
            else {
                li.add(nums1[a]);
                a++;
                b++;
            }
        }
        int[] ret = new int[li.size()];
        int i = 0;
        for (Integer l : li) {
            ret[i++] = l;
        }
        return ret;
    }
}
