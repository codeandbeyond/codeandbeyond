package com.optum.fs.rest.service.util.problems;

import java.io.IOException;

class HomeWork1 {

	public static void main(String[] args) throws IOException {
		int n = 5;
		System.out.println("\nHere is the Diamond of Stars\n");

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < (n - i); j++)
				System.out.print(" ");
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			for (int k = 1; k < i; k++)
				System.out.print("*");
			System.out.println();
		}

		for (int i = n - 1; i >= 1; i--) {
			for (int j = 0; j < (n - i); j++)
				System.out.print(" ");
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			for (int k = 1; k < i; k++)
				System.out.print("*");
			System.out.println();
		}

		System.out.println();
	}
}// main

