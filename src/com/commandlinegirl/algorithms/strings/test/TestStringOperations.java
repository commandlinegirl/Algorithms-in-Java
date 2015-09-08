package com.commandlinegirl.algorithms.strings.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.commandlinegirl.algorithms.strings.CheckPermutation;
import com.commandlinegirl.algorithms.strings.Permutation;
import com.commandlinegirl.algorithms.strings.UniqueChars;

public class TestStringOperations {

    @Test
    public void testUniqueCharacters() {
        assertTrue(UniqueChars.areCharactersUnique("abcsde"));
        assertFalse(UniqueChars.areCharactersUnique("abcsdea"));
        assertFalse(UniqueChars.areCharactersUnique("abcsdee"));
    }
    
    @Test
    public void testPermutation() {
        List<String> result = Permutation.permutate("abc");
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("cba"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertEquals(result.size(), 6);
        
        List<String> p2 = Permutation.permutate("aab");
        assertEquals(p2.size(), 2);
        
        p2 = Permutation.permutate("abcde");
        assertEquals(p2.size(), 120);
    }
    
    @Test
    public void testCheckPermutations() {
        assertTrue(CheckPermutation.checkPermutation("abc", "cba"));
        assertFalse(CheckPermutation.checkPermutation("abcc", "cba"));
        assertTrue(CheckPermutation.checkPermutation("", ""));
    }
}