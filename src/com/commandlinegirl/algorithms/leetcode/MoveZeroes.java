package com.commandlinegirl.algorithms.leetcode;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {

    public void moveZeroes1(int[] nums) {
            int i = 0;
            int j = 1;
            while (i < nums.length) {
                if (nums[i] == 0) {
                    while (j < nums.length - 1 && nums[j] == 0) {
                        j++;
                    }
                    if (j < nums.length && nums[j] != 0) {
                        swap(nums, i, j);
                    }
                }
                else {
                    j++;
                }
                i++;
            }
        }

        private void swap(int[] ar, int i, int j) {
            int tmp = ar[i];
            ar[i] = ar[j];
            ar[j] = tmp;
        }

    public void moveZeroes2(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCount++;
            else if (zeroCount > 0)
                nums[i - zeroCount] = nums[i];
        }
        for (int i = nums.length - zeroCount; i < nums.length; i++)
            nums[i] = 0;
    }


    public void moveZeroes3(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }
        while (index < nums.length)
            nums[index++] = 0;
    }
}
