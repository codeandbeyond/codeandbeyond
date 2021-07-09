package com.optum.fs.rest.service.util.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemovePairs {
	public static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));

	public static List<Integer> list = new ArrayList<Integer>();
	
	Stack<Integer> indexStack = new Stack<Integer>();

	public static void main(String[] args) {
	
		String input = "abbccadde";
		RemovePairs empmain = new RemovePairs();
		while (true) {
			if (empmain.checkDuplicate(input)) {
				System.out.print(input+" -->  ");
				input = empmain.removePairs(input).toString();
			} else {
				System.out.print(" " + input);
				
				break;
			}
		}

	}

	public StringBuffer removePairs(String expr) {
		StringBuffer sb = new StringBuffer();
		indexStack.push(0);
		for (int i = 1; i < expr.length() ; i++) {
			if (!indexStack.isEmpty() && i == indexStack.peek()+ 1
					&& expr.charAt(i) == expr.charAt(indexStack.peek())) {
				indexStack.pop();
			} else
				indexStack.push(i);
		}
		for (int i = indexStack.size()-1; i >=0; i--) {
			sb.append(expr.charAt(indexStack.get(i)));
			indexStack.pop();
		}
		return sb.reverse();
	}

	public boolean checkDuplicate(String expr) {
		boolean check = false;
		for (int i = 0; i < expr.length()-1; i++) {
			if (expr.charAt(i) == expr.charAt(i + 1))
				check = true;
		}
		return check;

	}
}
