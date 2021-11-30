package com.optum.fs.rest.service.util.problems;

public class CountInversions {
	public int getCountBrute(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j])
					count++;
			}
		}
		return count;
	}

	public int getCountMerge(int[] arr) {
		int temp[] = new int[arr.length];

		return mergeSort(arr, temp, 0, arr.length - 1);
	}

	private int mergeSort(int[] arr, int[] temp, int left, int right) {
		int mid;
		int inv_count = 0;
		if (right <= left)
			return 0;

		mid = left + (right - left) / 2;
		inv_count += mergeSort(arr, temp, left, mid);
		inv_count += mergeSort(arr, temp, mid + 1, right);
		inv_count += merge(arr, temp, left, mid, right);

		return inv_count;
	}

	private int merge(int[] arr, int[] temp, int left, int mid, int right) {
		int inv_count = 0;
		int i = left;
		int j = mid + 1;
		for (int k = 0; k <= right; k++) {
			temp[k] = arr[k];
		}
		for (int k = left; k <= right; k++) {
			if (i > mid) {
				arr[k] = temp[j++];
			} else if (j > right) {
				arr[k] = temp[i++];
			} else if (temp[i] < temp[j]) {
				arr[k] = temp[i++];

			} else {
				arr[k] = temp[j++];
				inv_count = inv_count + (mid - i + 1);
			}

		}
		return inv_count;
	}

	public static void main(String[] args) {
		CountInversions ci = new CountInversions();
		int arr[] ={1, 20, 6, 4, 5};
		System.out.println(" Inversion Count " + ci.getCountBrute(arr));
		System.out.println(" Inversion Count " + ci.getCountMerge(arr));

	}
}
