package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;

public class PrintInterleavedStrings {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        String interleaved = "";
        PrintInterleavedStrings printInterleavedStrings = new PrintInterleavedStrings();
        System.out.println(printInterleavedStrings.isInterleaved(s1, s2, s3));
        printInterleavedStrings.print(s1, s2, interleaved);
    }

    private boolean isInterleaved(String a, String b, String c) {
        if (a.length() == 0 && b.length() == 0) return true;
        if (a.length() + b.length() != c.length()) return false;
        int m = a.length();
        int n = b.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0 && j != 0) {
                    if (b.charAt(j - 1) == c.charAt(j - 1)) {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if (i != 0 && j == 0) {
                    if (a.charAt(i - 1) == c.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    char x = a.charAt(i - 1);
                    char y = b.charAt(j - 1);
                    char z = c.charAt(i + j - 1);
                    if (x == z && y != z) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (y == z && x != z) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (x == y && y == z) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private void print(String s1, String s2, String interleaved) {
        if (s1 == null) {
            System.out.println(s2);
            return;
        }
        if (s2 == null) {
            System.out.println(s1);
            return;
        }
        if (s1.length() == 0 && s2.length() == 0) {
            System.out.println(interleaved);
        }
        if (s1.length() != 0) {
            print(s1.substring(1), s2, interleaved + s1.charAt(0));
        }
        if (s2.length() != 0) {
            print(s1, s2.substring(1), interleaved + s2.charAt(0));
        }

    }
}
