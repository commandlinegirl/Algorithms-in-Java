package com.commandlinegirl.algorithms.interview;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.interviewbit.com/courses/programming/topics/heaps-and-maps/
 */
public class Chocolates {

    public int nchoc(int A, List<Integer> B) {
        Queue<Integer> q = new PriorityQueue<>(B.size(), (Integer a, Integer b)-> b.compareTo(a));
        for (Integer i : B) {
            q.add(i);
        }

        long sum = 0L;
        while (A > 0) {
            Integer i = q.poll();
            sum += i;
            q.offer(i / 2);
            A--;
        }
        return (int) (sum % 1000000007);
    }

    public static void main(String... str) {
        Chocolates c = new Chocolates();
        List<Integer> li = Arrays.asList(2147483647, 2000000014, 2147483647);
        int x = c.nchoc(10, li);
        System.out.println(x);
    }
}
