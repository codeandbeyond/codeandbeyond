package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        String expr = "( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )";
        for (String s : expr.split(" ")) {
            if (s.equals("+")) stack.push(s);
            else if (s.equals("*")) stack.push(s);
            else if (s.equals(")")) System.out.print(stack.pop() + " ");
            else if (s.equals("(")) System.out.print("");
            else System.out.print(s + " ");
        }
    }


}