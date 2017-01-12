package com.commandlinegirl.algorithms.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays {

    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> intersection = new HashSet<>();
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
                intersection.add(nums1[a]);
                a++;
                b++;
            }
        }
        return intersection.stream().mapToInt(i -> i).toArray();
    }
}
