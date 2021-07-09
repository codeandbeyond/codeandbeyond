package com.optum.fs.rest.service.util.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NoNumber {
	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
	/*
	 * public static Map<Long,List<Integer>> map=new
	 * HashMap<Long,List<Integer>>();
	 */
	private static List list = new ArrayList();

	public static void main(String[] args) {
		try {
			long numOfTestCases = Long.parseLong(reader.readLine());
			while (numOfTestCases > 0) {

				String[] input = reader.readLine().split(" ");
				long x = Long.parseLong(input[0]);
				long y = Long.parseLong(input[1]);
				if (x != y && x != y + 2) {
					list.add("No Number");
				} else {
					list.add(getNumber(x, y));
				}
				numOfTestCases--;
			}
			show();

		} catch (NumberFormatException e) {
			System.out.println("Only Numbers");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Only Numbers");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void show() {
		for (Object obj : list) {
			System.out.println("" + obj);
		}

	}

	private static long getNumber(long x, long y) {
		if (x % 2 != 0 && y % 2 != 0) {
			return (x + y - 1);
		} else {
			return x + y;
		}
	}
}
