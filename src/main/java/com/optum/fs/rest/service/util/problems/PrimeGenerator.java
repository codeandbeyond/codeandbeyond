package com.optum.fs.rest.service.util.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class PrimeGenerator {
	private static Boolean isPrime[];
	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
	public static Map<Integer, List<Long>> map = new HashMap<Integer, List<Long>>();
	
	public static void main(String[] args) {

		System.out.println("Enter Number Of test Cases");
		try {
			int numOfTestCases = Integer.parseInt(reader.readLine());
			System.out.println("--------------------------------");
			int i = 1;
			while (numOfTestCases <= 10 && numOfTestCases > 0) {
				List<Long> list = new ArrayList<Long>();
				String[] input = reader.readLine().split(" ");
				long low = Long.parseLong(input[0]);
				long high = Long.parseLong(input[1]);
				
				generatePrime(low, high + 1);
				for (long j = low; j <= high; j++) {
					if (checkPrime(j)) {
						list.add(j);

					}
				}

				map.put(i, list);
				i++;
				numOfTestCases--;
			}
		} catch (Exception e) {
			System.out.println("Please enter Numbers");
		}
		System.out.println("-----------------------------------");
		showPrime();

	}

	public static void generatePrime(long low, long l) {
		isPrime = new Boolean[(int) l];
		Arrays.fill(isPrime, true); // assume all integers are prime.
		isPrime[0] = isPrime[1] = false; // we know 0 and 1 are not prime.
		for (long i = low; i < isPrime.length; i++) {
			// if the number is prime,
			// then go through all its multiples and make their values false.
			if (isPrime[(int) i]) {
				for (long j = low; i * j < isPrime.length; j++) {
					isPrime[(int) (i * j)] = false;
				}
			}

		}

	}

	public static boolean checkPrime(long j) {
		return isPrime[(int) j];

	}

	public static void showPrime() {
		Iterator<Integer> itr = map.keySet().iterator();
		while (itr.hasNext()) {
			List<Long> list = map.get(itr.next());
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));

			}
			System.out.println("");
		}

	}
}
