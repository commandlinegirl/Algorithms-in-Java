package com.commandlinegirl.algorithms.sorting;

public class SortStrategy {

   private Sort strategy;

   public SortStrategy(Sort strategy) {
      this.strategy = strategy;
   }

   public void sort(int[] ar) {
      strategy.sort(ar);
   }
}
