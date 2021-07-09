package com.optum.fs.rest.service.util.problems;

public class MergeTwoArrays {
	public static void main(String[] args) {
		int mPlusN[] = { 2, 8, -1, -1, -1, 13, -1, 15, 20 };
		int N[] = { 5, 7, 9, 25 };
		int n = N.length;
		int m = mPlusN.length - n;
		moveTotheEnd(mPlusN, m + n);
		merge(mPlusN, N, m, n);
		printArray(mPlusN, mPlusN.length);
	}

	private static void printArray(int[] mPlusN, int length) {
		for (int num : mPlusN) {
			System.out.print(" "+num);
		}

	}

	private static void merge(int[] mPlusN, int[] N, int m, int n) {
		int i = n;
		int j = 0;
		int k = 0;
		while (k < (m + n)) {
			if (i < (m + n) && mPlusN[i] <= N[j]) {
				mPlusN[k++] = mPlusN[i++];
			} else {
				mPlusN[k++] = N[j++];
			}
		}

	}

	private static void moveTotheEnd(int[] mPlusN, int size) {
		int i = size - 1;
		for (int j = size - 1; j >= 0; j--) {
			if (mPlusN[j] != -1) {
				mPlusN[i] = mPlusN[j];
				i--;
			}
		}

	}
}
