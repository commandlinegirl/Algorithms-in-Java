package com.commandlinegirl.algorithms.leetcode;

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 | j >= 0) {
            int tmp = carry;
            if (i >= 0)
                tmp += toInt(a.charAt(i));
            if (j >= 0)
                tmp += toInt(b.charAt(j));

            carry = tmp < 2 ? 0 : 1;
            sb.append(tmp % 2 == 0 ? 0 : 1);
            i--;
            j--;
        }
        if (carry == 1)
            sb.append(carry);

        int m = sb.length() - 1;
        while (m > 0 && sb.charAt(m) == '0') {
            sb.setLength(m);
            m = sb.length() - 1;
        }

        return sb.reverse().toString();
    }

    private int toInt(char c) {
        return c - '0';
    }
}
