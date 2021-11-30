package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.calPoints(new String[]{"5","2","C","D","+"});

    }

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        int ans = 0;
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (op == "C") {
                stack.pop();
            } else if (op == "D") {
                int result = stack.peek();
                stack.push(2 * result);
            } else if (op == "+") {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2);
                stack.push(val1);
                stack.push(val1 + val2);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
