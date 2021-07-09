package com.optum.fs.rest.service.util;

public class LengthOfValidParenthesisString {
    public static void main(String[] args) {
        String string = ")()(())(";
        LengthOfValidParenthesisString lengthOfValidParenthesisString = new LengthOfValidParenthesisString();
        System.out.println(lengthOfValidParenthesisString.maxLength(string));
    }

    private int maxLength(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(2 * right, maxLength);
            }
            if (right >= left) {
                left = 0;
                right = 0;

            }
        }
        left = 0;right=0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(2 * left, maxLength);
            }
            if (left >= right) {
                left = 0;
                right = 0;

            }
        }
        return maxLength;
    }
}
