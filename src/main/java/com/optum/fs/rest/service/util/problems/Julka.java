package com.optum.fs.rest.service.util.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Julka {
	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
	public static List<Object> list = new ArrayList<Object>();

	public static void main(String[] args) {
		int i = 0;
		try {
			while (i < 10) {

				BigInteger totalNoOfapples = new BigInteger(reader.readLine());
				BigInteger noOfmoreapples = new BigInteger(reader.readLine());
				if (totalNoOfapples.compareTo(noOfmoreapples) < 0
						|| (totalNoOfapples.signum() == -1)
						|| noOfmoreapples.signum() == -1) {
					break;
				}
				getMeapples(totalNoOfapples, noOfmoreapples);
				i++;
			}
		} catch (Exception e) {
			System.out.println("Valid Inputs");
		}
		show();
	}

	private static void show() {
		for (Object obj : list) {
			System.out.println(obj);
		}

	}

	private static void getMeapples(BigInteger totalNoOfapples,
			BigInteger noOfmoreapples) {
		BigInteger val = new BigInteger("2");
		BigInteger y = (noOfmoreapples.add(totalNoOfapples)).divide(val);
		BigInteger x = (totalNoOfapples.subtract(noOfmoreapples)).divide(val);
		list.add(y + "\n" + x);

	}
}
