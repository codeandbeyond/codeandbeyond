package com.optum.fs.rest.service.util.leetcode;

public class CountWithEqualStartAndEnd {
    public static void main(String[] args) {
        CountWithEqualStartAndEnd countWithEqualStartAndEnd = new CountWithEqualStartAndEnd();
        String s = "abcab";
        countWithEqualStartAndEnd.countStrings(s);
    }

    private void countStrings(String s) {
        int[] charMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charMap[s.charAt(i) - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += (charMap[i] * (charMap[i] + 1)) / 2;
        }
        System.out.println(result);
    }
}
