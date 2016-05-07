package com.commandlinegirl.algorithms.recursion;

/*
Cracking the Coding Interview, 6th Edition
Problem 8.3 Magic Index
A magic index in an array A[1 ... n-1] is defined to be an index such that
A[i] = i. Given a sorted array of distinct integers, write a method to find
a magic index in A. What if the values are not distinct?
*/
class MagicIndex {

    private static int magicIndex(int[] arr, int s, int e) {
        if (e < s)
            return -1;

        int h = s + ((e - s) / 2);
        if (arr[h] < h) {
            return magicIndex(arr, h + 1, e);
        }
        else if (arr[h] > h) {
            return magicIndex(arr, s, h - 1);
        }
        return h;
    }

    private static int magicIndexNonDistinct(int[] arr, int s, int e) {
        if (e < s)
            return -1;

        int h = s + ((e - s) / 2);
        if (h == arr[h])
            return h;

        int left = magicIndexNonDistinct(arr, s, Integer.min(arr[h], h - 1));
        if (left >= 0)
            return left;

        int right = magicIndexNonDistinct(arr, h + 1, Integer.max(arr[h], h + 1));
        return right;
    }    

    public static void main(String... args) {
        int[] arr = {-11, 1, 3, 4, 5, 6, 300};
        System.out.println(magicIndex(arr, 0, arr.length - 1));
       
        int[] arr2 = {4, 4, 4, 4, 5, 5, 300};
        System.out.println(magicIndexNonDistinct(arr2, 0, arr.length - 1));
    }
}
