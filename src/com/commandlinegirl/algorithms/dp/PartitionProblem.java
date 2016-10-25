package com.commandlinegirl.algorithms.dp;

/**
 * Dynamic programming solution to the partition problem.
 */
public class PartitionProblem {

    /**
     * Recursive solution.
     * @param nums array of integers
     * @return
     */
    public boolean partitionRec(int[] nums) {
        int halfSum = sum(nums) >> 1;
        return (halfSum % 2 == 0) && isSubset(nums, halfSum, nums.length - 1);
    }

    private boolean isSubset(int[] nums, int sum, int n) {
        if (sum == 0)
            return true;
        if (n <= 0 && sum > 0)
            return false;

        if (nums[n] > sum)
            isSubset(nums, sum, n - 1);

        return isSubset(nums, sum, n - 1) || isSubset(nums, sum - nums[n], n - 1);
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int x : nums)
            sum += x;
        return sum;
    }

    /**
     * Bottom-up table solution.
     * @param s array of integers
     * @return
     */
    public boolean partition(int[] s) {
        if (s == null)
            throw new IllegalArgumentException("null input array");
        int n = s.length;
        int sum = getSum(s);
        if (sum % 2 != 0)
            return false;
        int halfSum = sum >> 1;

        // p[i][j] is true if there is a subset of {x(1), .., x(j)} that sums up to i, false otherwise
        boolean[][] p = new boolean[halfSum + 1][n + 1];

        //initialize top row of p to true
        for (int i = 0; i <= n; i++)
            p[0][i] = true;

        //initialize first column of p to false (except for p[0][0])
        for (int i = 1; i <= halfSum; i++)
            p[i][0] = false;

        for (int i = 1; i <= halfSum; i++) {
            for (int j = 1; j <= n; j++) {
                p[i][j] = p[i][j-1];
                if (i >= s[j-1])
                    // check also if there is a subset of {x(1), .., x(j-1)} that sums to i − xj,
                    // since x(j) + that subset's sum equal i.
                    p[i][j] = p[i][j - 1] || p[i - s[j - 1]][j - 1];
            }
        }

        // p[halfSum][n] is true iff there exists a subset that sums to halfSum
        return p[halfSum][n];
    }

    /***
     * Returns a sum of elements in the array.
     */
    private int getSum(int[] s) {
        int ret = 0;
        for (int i : s)
            ret += i;
        return ret;
    }

}
