package com.optum.fs.rest.service.util.leetcode;

public class LongestLengthPalindrome {
    public static void main(String[] args) {
        LongestLengthPalindrome longestLengthPalindrome = new LongestLengthPalindrome();
        String s = "abccccdd";
        longestLengthPalindrome.longestPalindrome(s);
    }

    public int longestPalindrome(String s) {
        int[] charMap = new int[128];
        int result = 0;
        for (char c : s.toCharArray()) {
            charMap[c]++;
        }
        for (int i = 0; i < 128; i++) {
            result += charMap[i] / 2 * 2;
            if (result % 2 == 0 && charMap[i] % 2 == 1) {
                result += 1;

            }
        }
        return result;
    }
}
