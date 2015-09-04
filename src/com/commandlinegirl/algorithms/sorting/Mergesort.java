package com.commandlinegirl.algorithms.sorting;

/* 
 * Mergesort implementation. 
 */
public class Mergesort implements Sort {

	private void merge(int[] ar, int[] tmp, int left, int right, int rightEnd) {
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;

		while(left <= leftEnd && right <= rightEnd)
			if(ar[left] <= (ar[right])) {
				tmp[k++] = ar[left++];
			} else {
				tmp[k++] = ar[right++];
			}

		while(left <= leftEnd)    // Copy rest of first half
		    tmp[k++] = ar[left++];

		while(right <= rightEnd)  // Copy rest of right half
			tmp[k++] = ar[right++];

		for(int i = 0; i < num; i++, rightEnd--) {
			ar[rightEnd] = tmp[rightEnd];
		}

	}

	private void mergeSort(int[] ar, int[] tmp, int left, int right) {
		if (left < right) {
			int mid = (left + right) >>> 1;
			mergeSort(ar, tmp, left, mid);
			mergeSort(ar, tmp, mid + 1, right);
			merge(ar, tmp, left, mid + 1, right);
		}
	}

	@Override
	public void sort(int[] ar) {
		if (ar == null) {
			return;
		}
		int[] tmp = new int[ar.length];
		mergeSort(ar, tmp, 0, ar.length - 1);
	}

}

