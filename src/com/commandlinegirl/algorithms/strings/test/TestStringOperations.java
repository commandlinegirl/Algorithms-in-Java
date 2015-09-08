package com.commandlinegirl.algorithms.strings.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.commandlinegirl.algorithms.strings.CheckPermutation;
import com.commandlinegirl.algorithms.strings.UniqueChars;

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
}