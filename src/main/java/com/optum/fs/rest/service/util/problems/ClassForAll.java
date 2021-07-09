package com.optum.fs.rest.service.util.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ClassForAll {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(
			System.in));
	private static List<Integer> list = new ArrayList<Integer>();
	

	public static void main(String[] args) throws IOException {

		String input = reader.readLine();
		int i = 0;
		try {
			while (i < Integer.parseInt(input)) {

				String inputString = reader.readLine();
				list.add(countNoOfzeros(Integer.parseInt(inputString)));
				/*
				 * String[] inputArray = inputString.split(" ");
				 * list.add(reverse(reverse(Integer.parseInt(inputArray[0])) +
				 * reverse(Integer.parseInt(inputArray[1]))));
				 */
				i++;
			}

			display(list);

		} catch (Exception e) {
			System.out.println("Please enter Numbers ");
		}
		
	}

	public static int reverse(Integer number) {

		int rev = 0;
		while (number > 0) {
			int rem = number % 10;
			rev = rev * 10 + rem;
			number /= 10;
		}
		return rev;

	}

	public static int countNoOfzeros(int num) {
		// Initialize result
		int count = 0;

		// Keep dividing n by powers of 5 and update count
		for (int i = 5; num / i >= 1; i *= 5)
			count += num / i;

		return count;
	}

	public static void display(List<Integer> list) {
		for (int j = 0; j < list.size(); j++) {
			System.out.println("" + list.get(j));
		}
	}
}
