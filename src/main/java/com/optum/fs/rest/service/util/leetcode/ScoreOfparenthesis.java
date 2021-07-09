package com.optum.fs.rest.service.util.leetcode;

import java.util.Stack;

public class ScoreOfparenthesis {
    public static void main(String[] args) {
        ScoreOfparenthesis scoreOfparenthesis= new ScoreOfparenthesis();
        scoreOfparenthesis.scoreOfParentheses("(()(()))");
    }

    public int scoreOfParentheses(String S) {
        int score = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + Math.max(2 * score, 1);
            }
        }
        return score;

    }
}
