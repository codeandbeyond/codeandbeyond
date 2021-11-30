package com.optum.fs.rest.service.util.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class SimpleFactorialBigInteger {
	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
	private static List<BigInteger> list = new ArrayList<BigInteger>();

	public static void main(String[] args) throws IOException {
		System.out.println("--------------------------");

		String input = reader.readLine();
		int i = 0;
		try {
			while (i < Integer.parseInt(input)) {

				String inputString = reader.readLine();
				list.add(generateFactorial(Integer.parseInt(inputString)));
				i++;
			}

			dsplay(list);

		} catch (Exception e) {

		}
	}

	private static void dsplay(List<BigInteger> list2) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("" + list.get(i));
		}
	}

	public static BigInteger generateFactorial(int num) {
		BigInteger fact = BigInteger.valueOf(1);

		if (num == 0) {
			return fact;
		} else {

			for (int i = 1; i <= num; i++) {
				fact = fact.multiply(BigInteger.valueOf(i));
			}
			return fact;
		}
	}
}