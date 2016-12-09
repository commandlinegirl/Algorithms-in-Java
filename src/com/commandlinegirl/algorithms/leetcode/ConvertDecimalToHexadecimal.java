package com.commandlinegirl.algorithms.leetcode;

/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */
public class ConvertDecimalToHexadecimal {

    char[] d2h = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        long l = num;
        if (l < 0)
            l = (1L << 32) + l;

        while (l != 0) {
            sb.append(d2h[(int) (l % 16)]);
            l /= 16;
        }

        return sb.reverse().toString();
    }

}
