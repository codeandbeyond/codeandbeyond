package com.optum.fs.rest.service.util.problems;

public class MedianOfSortedArrays {

	public int getMedian(int[] arr1, int[] arr2) {
		int m1 = -1;
		int m2 = -1;
		int i = 0;
		int j = 0;
		for (int count = 0; count <= arr1.length; count++) {
			if (i == arr1.length) {
				m1 = m2;
				m2 = arr2[0];
				break;
			}
			if (j == arr2.length) {
				m1 = m2;
				m2 = arr1[0];
				break;
			}
			if (arr1[i] < arr2[j]) {
				m1 = m2;
				m2 = arr1[i];
				i++;
			} else {
				m1 = m2;
				m2 = arr2[j];
				j++;
			}

		}
		return (m1 + m2) / 2;
	}

	public static void main(String[] args) {
		int arr1[] = { 1, 3 };
		int arr2[] = { 2 };
		MedianOfSortedArrays msa = new MedianOfSortedArrays();
		System.out.println(" Median of Two Sorted arrays are "
				+ msa.getMedian(arr1, arr2));
	}
}
