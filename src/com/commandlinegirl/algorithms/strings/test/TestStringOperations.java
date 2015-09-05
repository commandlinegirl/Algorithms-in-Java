package com.commandlinegirl.algorithms.strings.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.commandlinegirl.algorithms.strings.UniqueCharacters;

public class TestStringOperations {

    @Test
    public void testUniqueCharacters() {
        assertTrue(UniqueCharacters.areCharactersUnique("abcsde"));
        assertFalse(UniqueCharacters.areCharactersUnique("abcsdea"));
        assertFalse(UniqueCharacters.areCharactersUnique("abcsdee"));
    }
}