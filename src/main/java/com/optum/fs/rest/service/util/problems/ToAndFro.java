package com.optum.fs.rest.service.util.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ToAndFro {
	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
	static String[] arr = new String[200];
	static int rows;
	static int column;

	public static List<String> answer = new ArrayList<String>();

	public static void main(String[] args) {
		try {
			while (true) {
				column = Integer.parseInt(reader.readLine());
				if (column == 0 || column < 2 || column > 20) {
					break;
				} else {
					String input = reader.readLine();
					createMatrix(input, column);
					getString(column);
				}
			}
			show();

		} catch (Exception e) {
			System.out.println("Valid Inputs");
		}
	}

	public static void getString(int column) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < rows; j++) {
				sb.append(arr[j].charAt(i));
			}
		}
		answer.add(sb.toString());
		sb.delete(0, sb.length());
	}

	public static void show() {
		for (String word : answer) {
			System.out.println(word);
		}
	}

	public static void createMatrix(String input, int column) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < input.length(); i = i + column) {
			int start = i;
			int end = i + column;
			if (end >= input.length() + 1) {
				list.add(input.substring(start));
			} else {
				list.add(input.substring(start, end));
			}
		}
		rows = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				arr[rows] = list.get(i);
			} else if (i % 2 != 0) {
				StringBuffer sb = new StringBuffer(list.get(i));
				arr[rows] = sb.reverse().toString();
				sb.delete(0, sb.length());
			} else {
				arr[rows] = list.get(i);
			}
			rows++;
		}
	}
}
