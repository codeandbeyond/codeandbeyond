package com.optum.fs.rest.service.util.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {
	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
	public static Stack<Character> stack = new Stack<Character>();
	public static List<String> list = new ArrayList<String>();
 

	public static void main(String[] args) {
		try {
			int numOfTestCases = Integer.parseInt(reader.readLine());
			while (numOfTestCases > 0) {
				String infix = reader.readLine();
				String output = infixToPostfix(infix);
				list.add(output);
				numOfTestCases--;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Valid Inputs");
		}
		show();
	}

	public static void show() {
		for (String output : list) {
			System.out.println(output);
		}

	}

	public static String infixToPostfix(String infix) {
		StringBuffer output = new StringBuffer();
		char val;
		for (int i = 0; i < infix.length(); i++) {
			val = infix.charAt(i);
			if (isOperand(val)) {
				output = output.append(val);
			} else if (val == '(') {
				stack.push(val);
			} else if (val == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					output = output.append(stack.pop());
				}
				if (!stack.isEmpty() && stack.peek() != '(') {
					//System.out.println("Invalid Expression");
					break;
				} else {
					stack.pop();
				}

			} else {
				while (!stack.isEmpty()
						&& precedence(val) <= precedence(stack.peek())) {
					output = output.append(stack.pop());
				}
				stack.push(val);
			}
		}
		while (!stack.isEmpty()) {
			output = output.append(stack.pop());
		}
		return output.toString();
	}

	public static boolean isOperand(char ch) {
		if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
			return true;
		else
			return false;

	}

	public static int precedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;

		}
	}
}
