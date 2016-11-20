package com.commandlinegirl.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i]) && Math.abs(m.get(nums[i]) - i) <= k)
                return true;
            m.put(nums[i], i);
        }
        return false;
    }

}
