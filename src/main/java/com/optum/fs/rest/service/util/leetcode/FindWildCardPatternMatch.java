package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;

public class FindWildCardPatternMatch {
    public static void main(String[] args) {
        FindWildCardPatternMatch findWildCardPatternMatch = new FindWildCardPatternMatch();
        String pat1 = "*ab";
        String word1 = "bab";
        boolean status = findWildCardPatternMatch.findMatchDp(pat1, word1);
        System.out.println(status ? "Match" : "Not a Match");
    }

    private boolean findMatch(String pat1, String word1) {
        if (pat1.length() == 0 && word1.length() == 0) {
            return true;
        }
        if (pat1.length() > 1 && pat1.charAt(0) == '*' && word1.length() == 0) {
            return false;
        }
        if (pat1.length() > 1 && pat1.charAt(0) == '?' || pat1.length() != 0 && word1.length() != 0 && pat1.charAt(0) == word1.charAt(0)) {
            return findMatch(pat1.substring(1), word1.substring(1));
        }
        if (pat1.length() > 1 && pat1.charAt(0) == '*') {
            return findMatch(pat1.substring(1), word1) || findMatch(pat1, word1.substring(1));
        }
        return false;
    }

    private boolean findMatchDp(String pat1, String word1) {
        if (pat1.length() == 0) return word1.length() == 0;
        int m = pat1.length();
        int n = word1.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (pat1.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pat1.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (pat1.charAt(i - 1) == '?' || pat1.charAt(i - 1) == word1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
}
