package com.optum.fs.rest.service.util.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FashionShows {
	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
	public static List<Integer> list = new ArrayList<Integer>();
	static Integer[] arr_men = new Integer[1000];
	static Integer[] arr_women = new Integer[1000];

	public static void main(String[] args) {
		try {

			System.out.println("Number of testcases");
			int numOfTestcases = Integer.parseInt(reader.readLine());
			while (numOfTestcases > 0) {
				int N = Integer.parseInt(reader.readLine());
				if (N < 1 || N > 1000) {
					break;
				}
				int hotness = 0;
				String input_men = reader.readLine();
				arr_men = processLine(input_men.split(" "));

				String input_women = reader.readLine();
				arr_women = processLine(input_women.split(" "));

				if (arr_men.length != N && arr_women.length != N) {
					break;
				}
				Arrays.sort(arr_women);
				Arrays.sort(arr_men);
				for (int i = 0; i < arr_men.length; i++) {
					if ((arr_men[i] < 0 || arr_men[i] > 10)
							&& (arr_women[i] < 0 || arr_women[i] > 10)) {
						break;
					} else {

						hotness = hotness + (arr_women[i] * arr_men[i]);

					}

				}
				list.add(hotness);

				numOfTestcases--;
			}
			show();
		} catch (Exception e) {
			System.out.println("Valid inputs");
		}

	}

	public static Integer[] processLine(String[] strings) {
		Integer[] intarray = new Integer[strings.length];
		int i = 0;
		for (String str : strings) {
			intarray[i] = Integer.parseInt(str);// Exception in this line
			i++;
		}
		return intarray;
	}

	public static void show() {
		for (Integer hot : list) {
			System.out.println(hot);
		}
	}

}
