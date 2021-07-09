package com.optum.fs.rest.service.util.problems;

import java.util.HashMap;
import java.util.Map;

public class NameToNumberUsingMobile {/*
									 * Either Initialize with Static block or
									 * Call The Method which i have written Each
									 * one has its own advantages,Static block will
									 * load once can be used in throughout till
									 * class is in Memory; or Call that Method
									 * but it will violate some of initial
									 * conditions of Mobile i mean just refer to
									 * Actual Mobile keyPad
									 */
	private static Map<Character, Integer> nameToNumber = new HashMap<Character, Integer>();
	static {
		nameToNumber.put('a', 1);
		nameToNumber.put('b', 1);
		nameToNumber.put('c', 1);
		nameToNumber.put('d', 2);
		nameToNumber.put('e', 2);
		nameToNumber.put('f', 2);
		nameToNumber.put('g', 3);
		nameToNumber.put('h', 3);
		nameToNumber.put('i', 3);
		nameToNumber.put('j', 4);
		nameToNumber.put('k', 4);
		nameToNumber.put('l', 4);
		nameToNumber.put('m', 5);
		nameToNumber.put('n', 5);
		nameToNumber.put('o', 5);
		nameToNumber.put('p', 6);
		nameToNumber.put('q', 6);
		nameToNumber.put('r', 6);
		nameToNumber.put('s', 7);
		nameToNumber.put('t', 7);
		nameToNumber.put('u', 7);
		nameToNumber.put('v', 8);
		nameToNumber.put('w', 8);
		nameToNumber.put('x', 8);
		nameToNumber.put('y', 9);
		nameToNumber.put('z', 9);
	}

	public static void main(String[] args) {
		// initializeMapwithoutTension();Uncomment it If u want to make a call
		// to function to initialize your Map
		String name = "Ashok";
		String number = getNumber(name.toLowerCase());
		System.out.println("Number Represenation of " + name + " is:" + number);
	}

	private static String getNumber(String name) {
		StringBuffer number = new StringBuffer();
		for (int i = 0; i < name.length(); i++) {
			if (nameToNumber.containsKey(name.charAt(i))) {
				number.append(nameToNumber.get(name.charAt(i)));
			}
		}
		return number.toString();

	}

	public static void initializeMapwithoutTension() {
		char ch = 'a';
		for (Integer index = 1; index <= 9; index++) {
			int mod = 1;
			while (ch <= 'z') {

				if (mod % 3 != 0) {
					nameToNumber.put(ch, index);
					ch++;
					mod++;
				} else {
					nameToNumber.put(ch, index);
					ch++;
					mod = 1;
					break;
				}
			}

		}
	}

}
