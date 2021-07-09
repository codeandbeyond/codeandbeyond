package com.optum.fs.rest.service.util.leetcode;

public class PalindromPartioning {
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        PalindromPartioning palindromPartioning = new PalindromPartioning();
        System.out.println(palindromPartioning.partition(str));

    }

    public int partition(String s) {
        int n = s.length();

        int[][] cut = new int[n][n];
        boolean[][] palindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            cut[i][i] = 0;
            palindrome[i][i] = true;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;

                if (l == 2) {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1];
                }
                if (palindrome[i][j]) {
                    cut[i][j] = 0;
                } else {
                    cut[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        cut[i][j] = Math.min(cut[i][j], cut[i][k] + cut[k + 1][j] + 1);
                    }
                }
            }
        }
        return cut[0][n - 1];
    }
}
