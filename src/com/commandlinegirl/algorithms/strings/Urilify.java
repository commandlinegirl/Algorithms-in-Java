package com.commandlinegirl.algorithms.strings;

/* Write a method to replace all spaces in a string with '%20', in place. 
 * You may assume the string has sufficient space to hold the additional
 * characters (spaces at the end). */
public class Urilify {

    public static char[] urilify(char[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException("Input chars is null.");
        }
        
        int i = chars.length - 1;
        int j = i;
        boolean passedTrailngSpace = false;
        while (i >= 0) {
            if (chars[i] != ' ') {
                passedTrailngSpace = true;
                chars[j--] = chars[i];
            }
            
            if (chars[i] == ' ' && passedTrailngSpace) {
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            }
            i--;
        }
        
        if (!passedTrailngSpace) {
            chars[0] = '%';
            chars[1] = '2';
            chars[2] = '0';
        }
        
        return chars;
    }
    
    
}
