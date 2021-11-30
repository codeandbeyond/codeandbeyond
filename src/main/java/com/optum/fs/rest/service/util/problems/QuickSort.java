package com.optum.fs.rest.service.util.problems;

public class QuickSort {
	public int partition(int lo, int hi, int[] arr) {
		int i = lo;
		int j = hi + 1;
		int v = arr[lo];
		while (true) {
			while (isLess(arr[++i], v)) {
				if (i == hi)
					break;
			}
			while (isLess(v, arr[--j])) {
				if (j == lo)
					break;
			}
			if (i >= j) {
				break;
			}
			exchange(arr, i, j);
		}
		exchange(arr, lo, j);
		return j;

	}

	private void exchange(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	private boolean isLess(int i, int v) {
		// TODO Auto-generated method stub
		return i < v ? true : false;
	}

	public void sort(int[] arr, int lo, int hi) {
		if (lo >= hi)
			return;
		int partition = partition(lo, hi, arr);
		sort(arr, lo, partition - 1);
		sort(arr, partition + 1, hi);
	}

	public int quickSelect(int[] arr, int lo, int hi, int k) {
		while (lo <= hi) {
			int pivotIndex = partition(lo, hi, arr);
			if (pivotIndex == k - 1)
				return arr[pivotIndex];
			else if (pivotIndex > k - 1)
				hi = pivotIndex - 1;
			else
				lo = pivotIndex + 1;
		}
		return arr[lo];
	}

	public static void main(String[] args) {
		int arr[] = { 5, 1, 4, 3, 2 };
		QuickSort quick = new QuickSort();
	/*	quick.sort(arr, 0, arr.length - 1);
		for (int elem : arr)
			System.out.print(elem + " ");*/
		System.out.println(quick.toString());

		System.out.println(" " + quick.quickSelect(arr, 0, arr.length - 1, 1));
	}

}
