package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.Stack;

public class BalancedParantheses {
    public static void main(String[] args) {
        String expression = "[()]{}{[()()]()}";
        System.out.println(isBalanced(expression));
        String expression2 = "[()]{}{[()()]()";
        System.out.println(isBalanced(expression2));
    }

    private static boolean isBalanced(String expression) {
        Stack<String> stack = new Stack<String>();
        for (String expr : expression.split("")) {
            if (expr.equals("(")) {
                stack.push(expr);
            } else if (expr.equals("{")) {
                stack.push(expr);
            } else if (expr.equals("[")) {
                stack.push(expr);
            } else if (expr.equals(")")) {
                if (stack.isEmpty())
                    return false;
                if (!stack.pop().equals("("))
                    return false;
            } else if (expr.equals("}")) {
                if (stack.isEmpty())
                    return false;
                if (!stack.pop().equals("{"))
                    return false;
            } else if (expr.equals("]")) {
                if (stack.isEmpty())
                    return false;
                if (!stack.pop().equals("["))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
