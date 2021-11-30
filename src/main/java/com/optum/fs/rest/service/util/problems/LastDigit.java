package com.optum.fs.rest.service.util.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LastDigit {
	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
	static List<Object> list = new ArrayList<Object>();

	public static void main(String[] args) {
		try {
			int numOfTestcases = Integer.parseInt(reader.readLine());
			while (numOfTestcases <= 30 && numOfTestcases > 0) {
				String[] input = reader.readLine().split(" ");
				BigInteger a = new BigInteger(input[0]);
				BigInteger b = new BigInteger(input[1]);
				if (a.compareTo(new BigInteger("20")) > 0
						&& a.compareTo(new BigInteger("0")) < 0
						|| b.compareTo(new BigInteger("2147483000")) > 0
						&& b.compareTo(new BigInteger("0")) < 0
						|| b.compareTo(new BigInteger("0")) == 0
						&& (a.compareTo(new BigInteger("0")) == 0)) {
					break;
				}
				list.add(getMeLastDigit(a, b));
				numOfTestcases--;
			}
			show();
		} catch (Exception e) {
			System.out.println("Valid Input");
		}
	}

	private static void show() {
		for (Object obj : list) {
			System.out.println(obj);
		}

	}

	private static Object getMeLastDigit(BigInteger a, BigInteger b) {
		return a.modPow(b, new BigInteger("10"));

	}
}
