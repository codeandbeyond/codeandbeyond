package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class NumberOfPossiblePaths {
    public static void main(String[] args) {
        int m = 4;
        int n = 4;
        System.out.println(" " + printPossiblePaths(m, n));
        System.out.println(" " + printPossiblePathsDP(m, n));
        System.out.println(" " + printPossiblePathsSpaceOptimized(m, n));
    }

    private static int printPossiblePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return printPossiblePaths(m - 1, n) + printPossiblePaths(m, n - 1);

    }

    private static int printPossiblePathsDP(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }

        }
        return dp[m - 1][n - 1];

    }

    private static int printPossiblePathsSpaceOptimized(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];

    }
}
