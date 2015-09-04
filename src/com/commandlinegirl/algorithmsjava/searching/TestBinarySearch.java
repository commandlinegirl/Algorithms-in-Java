package com.commandlinegirl.algorithmsjava.searching;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TestBinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        List<Integer> list = Arrays.asList(new Integer[] {1, 2, 2, 3, 4, 5, 10, 18});
        // Existing element
        int result = bs.binarySearch(list, 3);
        assert result == 3;
        System.out.println(result);

        // Non-existing element
        result = bs.binarySearch(list, 0);
        System.out.println(result);
        assert result == -1;

        // Empty list
        list = Arrays.asList(new Integer[] {});
        result = bs.binarySearch(list, 20);
        assert result == -1;

        // First element
        result = bs.binarySearch(list, 1);
        assert result == 0;

        // Last element
        result = bs.binarySearch(list, 18);
        assert result == 7;

    }
}
