package com.optum.fs.rest.service.util.leetcode;

public class MinimumRemoveForValidParenthesis {
    public static void main(String[] args) {
        MinimumRemoveForValidParenthesis minimumRemoveForValidParenthesis = new MinimumRemoveForValidParenthesis();
        System.out.println(minimumRemoveForValidParenthesis.minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    public String minRemoveToMakeValid(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int open = 0;
        for (char c : string.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) continue;
                open--;

            }
            stringBuilder.append(c);
        }

        StringBuilder result = new StringBuilder();

        for (int i = stringBuilder.length() - 1; i >= 0; i--) {
            if (stringBuilder.charAt(i) == '(' && open-- > 0) continue;
            result.append(stringBuilder.charAt(i));
        }
        return result.reverse().toString();

    }
}

