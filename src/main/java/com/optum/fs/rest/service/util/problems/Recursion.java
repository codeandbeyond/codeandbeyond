package com.optum.fs.rest.service.util.problems;

public class Recursion {
	static int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

	public static void main(String[] args) {
		System.out.println(" max costpath " + costPath(arr, 0, 0));
		System.out.println(" Dollars:::" + BytelandianConversion(12));
	}

	public static int costPath(int arr[][], int i, int j) {
		int t1 = 0, t2 = 0, t = 0, t3 = 0;
		if (i > arr.length - 1 || j > arr.length - 1)
			return 0;
		else {
			t1 = costPath(arr, i + 1, j);
			t2 = costPath(arr, i + 1, j + 1);
			t3 = costPath(arr, i, j + 1);
			int max = max(t1, t2);
			t = max(max, t3) + arr[i][j];
		}
		return t;

	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static int BytelandianConversion(int byteLandAmount) {
		int half = byteLandAmount / 2;
		int oneThird = byteLandAmount / 3;
		int oneForth = byteLandAmount / 4;

		int total = half + oneForth + oneThird;
		if (byteLandAmount > total) {
			return byteLandAmount;
		} else {
			int maxHalf = BytelandianConversion(half);
			int maxThird = BytelandianConversion(oneThird);
			int maxForth = BytelandianConversion(oneForth);
			return (maxHalf + maxThird + maxForth);
		}

	}
}
