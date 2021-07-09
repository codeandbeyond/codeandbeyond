package com.optum.fs.rest.service.util.problems;

public class Equilibrium {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(getMissingNumber(arr.length , arr));
	}

	public static int getMissingNumber(int n, int a[]) {
		int i;
		int x1 = a[0]; /* For xor of all the elements in array */
		int x2 = 1; /* For xor of all the elements from 1 to n+1 */

		for (i = 1; i < n; i++)
			x1 = x1 ^ a[i];

		for (i = 2; i <= n + 1; i++)
			x2 = x2 ^ i;

		return (x1 ^ x2);
	}
}
