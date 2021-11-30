package com.optum.fs.rest.service.util.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Candy3 {
	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));

	public static List<Object> list = new ArrayList<Object>();

	public static void main(String[] args) {
		try {
			System.out.println("Enter");
			int numofTestCases = Integer.parseInt(reader.readLine());
			while (numofTestCases > 0) {
				System.out.println("");
				int numOfChildren = Integer.parseInt(reader.readLine());
				/* int arr[]=new int[numOfChildren]; */
				long sum = 0;

				for (int i = 0; i < numOfChildren; i++) {
					sum +=Long.parseLong(reader.readLine());
					if (sum >= numOfChildren) {
						sum = sum % numOfChildren;
					}
				}
				if (sum == 0) {
					list.add("Yes");
				} else {
					list.add("NO");
				}
				numofTestCases--;
			}
			show();
		} catch (Exception e) {
			System.out.println("Valid Inputs");
		}

	}

	private static void show() {
		for (Object obj : list) {
			System.out.println(obj);
		}

	}
}
