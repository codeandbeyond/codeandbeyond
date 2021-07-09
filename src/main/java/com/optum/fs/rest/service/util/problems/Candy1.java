package com.optum.fs.rest.service.util.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Candy1 {

	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));

	public static List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		try {
			while (true) {
				
				int numberOfLines = Integer.parseInt(reader.readLine());
				if (numberOfLines == -1 || numberOfLines > 10000) {
					break;
				} else {
					int i = 0;
					int arr[] = new int[numberOfLines];
					while (i < numberOfLines) {
						arr[i] = Integer.parseInt(reader.readLine());
						i++;
					}
					list.add(get_numberof_moves(arr));
				}
			}
			show();
		} catch (Exception e) {
			System.out.println("Valid Inputs");
		}

	}

	private static void show() {
		for (Integer moves : list) {
			System.out.println(moves);
		}

	}

	private static int get_numberof_moves(int arr[]) {
	
		int sum = find_sum(arr);
		int equivalent_amount;
		int no_of_moves = 0;
		if (sum % arr.length != 0) {
			no_of_moves = -1;
		} else {
			equivalent_amount = sum / (arr.length);
			for (int i = 0; i < arr.length; i++) {
				while (arr[i] > equivalent_amount) {
					no_of_moves++;
					arr[i]--;
				}
			}

		}
		return no_of_moves;

	}

	private static int find_sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}


}
