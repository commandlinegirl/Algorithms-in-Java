package com.commandlinegirl.algorithms.strings.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.commandlinegirl.algorithms.strings.CheckPermutation;
import com.commandlinegirl.algorithms.strings.UniqueChars;
import com.commandlinegirl.algorithms.strings.Urilify;

public class TestStringOperations {

    @Test
    public void testUniqueCharacters() {
        assertTrue(UniqueChars.areCharactersUnique("abcsde"));
        assertFalse(UniqueChars.areCharactersUnique("abcsdea"));
        assertFalse(UniqueChars.areCharactersUnique("abcsdee"));
    }
    
    @Test
    public void testCheckPermutations() {
        assertTrue(CheckPermutation.checkPermutation("abc", "cba"));
        assertFalse(CheckPermutation.checkPermutation("abcc", "cba"));
        assertTrue(CheckPermutation.checkPermutation("", ""));
    }
    
    @Test
    public void testUrilify() {
        char[] result = Urilify.urilify("Mr John Smith    ".toCharArray());
        assertEquals(String.valueOf(result), "Mr%20John%20Smith");
        result = Urilify.urilify("   ".toCharArray());
        assertEquals(String.valueOf(result), "%20");
    }

}