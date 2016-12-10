package com.commandlinegirl.algorithms.leetcode;

/**
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {

    /**
     * Time complexity: O(|ransomNote| + |magazine|)
     * Memory complexity: O(|alphabet size|)
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] pool = new int[26];
        for (char c : magazine.toCharArray())
            pool[c % 97]++;
        for (char c : ransomNote.toCharArray()) {
            if (pool[c % 97] <= 0)
                return false;
            pool[c % 97]--;
        }
        return true;
    }
}
