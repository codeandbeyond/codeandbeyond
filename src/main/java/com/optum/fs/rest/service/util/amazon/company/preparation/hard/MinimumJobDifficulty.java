package com.optum.fs.rest.service.util.amazon.company.preparation.hard;

public class MinimumJobDifficulty {
    public static void main(String[] args) {
        int[] A = {6, 5, 7, 3};
        int day = 3;
        MinimumJobDifficulty minimumJobDifficulty = new MinimumJobDifficulty();
        minimumJobDifficulty.minDifficulty(A, day);
    }

    public int minDifficulty(int[] A, int D) {
        int n = A.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i+1], A[i]);
        }

        for (int day = 2; day <= D; day++) {

            for (int i = 0; i <= n - day; i++) {
                dp[i] = Integer.MAX_VALUE;
                int maxD = 0;

                for (int j = i; j <= n - day; j++) {
                    maxD = Math.max(maxD, A[j]);
                    dp[i] = Math.min(dp[i], maxD + dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}
