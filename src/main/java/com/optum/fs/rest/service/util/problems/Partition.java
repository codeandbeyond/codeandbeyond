package com.optum.fs.rest.service.util.problems;

public class Partition {
	public static void main(String[] args) {
		int arr[] = { 3, 1, 1, 2, 2, 1 };
		System.out.println("Can The array be partioned? " + isSum(arr));
		System.out.println("Can The array be partioned? "
				+ findPartion(arr, arr.length));
	}

	public static boolean isSum(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		if (sum % 2 != 0) {
			return false;
		} else
			return recursivePartition(arr, arr.length, sum / 2);

	}

	private static boolean recursivePartition(int[] arr, int n, int sum) {
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;
		else if (arr[n - 1] > sum)
			return false;
		else
			return (recursivePartition(arr, n - 1, sum) || recursivePartition(
					arr, n - 1, sum - arr[n - 1]));
	}

	private static boolean findPartion(int[] arr, int n) {
		int sum = 0;
		int i, j;

		// Caculcate sum of all elements
		for (i = 0; i < n; i++)
			sum += arr[i];

		if (sum % 2 != 0)
			return false;

		boolean[][] part = new boolean[sum / 2 + 1][n + 1];

		// initialize top row as true
		for (i = 0; i <= n; i++)
			part[0][i] = true;

		// initialize leftmost column, except part[0][0], as 0
		for (i = 1; i <= sum / 2; i++)
			part[i][0] = false;

		// Fill the partition table in botton up manner
		for (i = 1; i <= sum / 2; i++) {
			for (j = 1; j <= n; j++) {
				part[i][j] = part[i][j - 1];
				if (i >= arr[j - 1])
					part[i][j] = part[i][j] || part[i - arr[j - 1]][j - 1];
			}
		}

		for (i = 0; i <= sum / 2; i++) {
			for (j = 0; j <= n; j++)
				System.out.print(part[i][j]+" ");
			System.out.print("\n");
		}

		return part[sum / 2][n];

	}
}
