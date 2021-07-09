package com.optum.fs.rest.service.util.problems;

import java.util.Stack;

public class MinimumNumberOfGivenSequence {
    public static void main(String[] args) {
        MinimumNumberOfGivenSequence minimumNumberOfGivensequence = new MinimumNumberOfGivenSequence();
        minimumNumberOfGivensequence.printMinimum("IDID");
        minimumNumberOfGivensequence.printMinimum("I");
        minimumNumberOfGivensequence.printMinimum("DD");
        minimumNumberOfGivensequence.printMinimum("II");
        minimumNumberOfGivensequence.printMinimum("DIDI");
    }

    private String printMinimum(String seq) {
        String result = "";

        Stack<Integer> stack = new Stack();

        for (int i = 0; i <= seq.length(); i++) {
            stack.push(i + 1);
            if (i == seq.length() || seq.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result += stack.peek();
                    result += " ";
                    stack.pop();
                }
            }
        }
        System.out.println("Result : "+result);
        return result;
    }

}
