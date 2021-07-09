package com.optum.fs.rest.service.util.leetcode;

public class LongestEvenLengthSubstring {
    public static void main(String[] args) {
        String string = "123123";
        LongestEvenLengthSubstring longestEvenLengthSubstring = new LongestEvenLengthSubstring();
        System.out.println(longestEvenLengthSubstring.findLength(string));
    }

    private int findLength(String string) {
        int n = string.length();
        int maxLength = 0;
        if (string == null || string.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < string.length() - 2; i++) {
            int l = i;
            int r = i + 1;
            int lSum = 0;
            int rSum = 0;

            while (l >= 0 && r < n) {
                lSum += string.charAt(l) - '0';
                rSum += string.charAt(r) - '0';
                if (lSum == rSum) {
                    maxLength = Math.max(maxLength, (r - l + 1));
                }
                l--;
                r++;
            }
        }
        return maxLength;
    }
}
