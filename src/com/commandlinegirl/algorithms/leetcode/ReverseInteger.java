package com.commandlinegirl.algorithms.leetcode;

public class ReverseInteger {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result != 0 && Integer.MAX_VALUE/result < 10 && Integer.MAX_VALUE/result > -10)
                return 0;
            result = result * 10 + x % 10;
            x /= 10;
        }

        return result;
    }
}
