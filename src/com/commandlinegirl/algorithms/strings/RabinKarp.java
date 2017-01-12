package com.commandlinegirl.algorithms.strings;

/**
 * Rabin Karp string search algorithm implementation
 */
public class RabinKarp {

    private final int PRIME = 101;

    /**
     * Returns the first index of the pattern that matched the searched pattern within
     * the string.
     * @param inputString
     * @param pattern
     * @return
     */
    public int searchPattern(String inputString, String pattern) {
        char[] charStr = inputString.toCharArray();
        char[] charPtrn = pattern.toCharArray();
        int m = inputString.length();
        int n = pattern.length();
        int patternHash = hash(charPtrn, 0, n - 1);
        int previousHash = -1;
        for (int i = 0; i < m - n + 1; i++) {
            int currentHash = rollingHash(charStr, i, i + n - 1, previousHash);
            if (patternHash == currentHash && cmpStrings(charStr, charPtrn, i, i + n - 1)) {
                return i;
            }
            previousHash = currentHash;
        }
        return -1;
    }

    /**
     * Returns a new hash of the string using the previous hash, the new character that is
     * added to the string and removing hash info related to the character removed from the string.
     * @param charStr
     * @param start
     * @param end
     * @param previousHash
     * @return
     */
    private int rollingHash(char[] charStr, int start, int end, int previousHash) {
        if (previousHash < 0 || start == 0) {
            return hash(charStr, start, end);
        }
        // Calculating a new hash using the old one: base * (old_hash - old_char) + new_car
        int oldCharIndex = start - 1;
        int oldCharExponent = end - start;
        return (int) (PRIME * (previousHash - charStr[oldCharIndex] * Math.pow(PRIME, oldCharExponent)) + charStr[end]);
    }

    /**
     *  Rabin fingerprint. Returns a hash of the substring within inputString between
     *  start and end indices, both inclusive.
     */
    private int hash(char[] inputString, int start, int end) {
        int hash = 0;
        for (int i = end, j = 0; i >= start; i--, j++) {
            hash += inputString[i] * Math.pow(PRIME, j);
        }
        return hash;
    }

    /**
     * Returns true if pattern matches the substring of string between start and end indices, both inclusive.
     * @param string
     * @param pattern
     * @param start
     * @param end
     * @return
     */
    private boolean cmpStrings(char[] string, char[] pattern, int start, int end) {
        for (int i = start, j = 0; i <= end && j < pattern.length; i++, j++) {
            if (string[i] != pattern[j]) {
                return false;
            }
        }
        return true;
    }

}
