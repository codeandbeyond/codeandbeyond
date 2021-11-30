package com.optum.fs.rest.service.util.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NoOfSquares {
	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));

	public static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter number of TestCases");
		while (true) {
			int input = Integer.parseInt(reader.readLine());
			if (input == 0) {
				break;
			} else {
				// list.add(getNumberOfSquares(input));
				System.out.println("Before Calling DP"
						+ System.currentTimeMillis());
				list.add(getNumberofSquaresUsingDP(input));
				System.out.println("After Calling DP"
						+ System.currentTimeMillis());
				// list.add(getNumberofSquaresUsingRecursion(input));

			}
		}
		show();

	}

	private static void show() {
		for (Integer num : list) {
			System.out.println(num);
		}

	}

	public static Integer getNumberOfSquares(int input) {
		int output = 0;
		for (int i = 1; i <= input; i++) {
			output += Math.pow(i, 2);
		}
		return output;
	}

	public static Integer getNumberofSquaresUsingRecursion(int input) {
		if (input == 0)
			return 0;
		return (int) (getNumberofSquaresUsingRecursion(input - 1) + Math.pow(
				input, 2));
	}

	public static Integer getNumberofSquaresUsingDP(int input) {
		int arr[] = new int[input + 1];
		arr[0] = 0;
		for (int i = 1; i <= input; i++) {
			arr[i] = (int) (arr[i - 1] + Math.pow(i, 2));
		}

		return arr[input];
	}
}
