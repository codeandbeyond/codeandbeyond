package com.optum.fs.rest.service.util.leetcode;

public class NumberOfPathExactlyKcoins {
    public static void main(String[] args) {
        NumberOfPathExactlyKcoins numberOfPathExactlyKcoins = new NumberOfPathExactlyKcoins();
        int k = 12;
        int mat[][] = {
                {1, 2, 3},
                {4, 6, 5},
                {3, 2, 1}
        };
        int R = mat.length;
        int C = mat[0].length;
        int ans = numberOfPathExactlyKcoins.pathCountWithKcoins(mat, k, R - 1, C - 1);
        System.out.println(" " + ans);
        int[][][] dp = new int[R][C][k+1];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int l = 0; l < k+1; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
       ans = numberOfPathExactlyKcoins.pathCountWithKcoinsDp(mat, k, R - 1, C - 1, dp);
        System.out.println(ans);
    }

    private int pathCountWithKcoins(int[][] mat, int k, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0 && j == 0 && k == mat[i][j]) {
            return 1;
        }
        return pathCountWithKcoins(mat, k - mat[i][j], i - 1, j) + pathCountWithKcoins(mat, k - mat[i][j], i, j - 1);

    }

    private int pathCountWithKcoinsDp(int[][] mat, int k, int i, int j, int[][][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return k == mat[i][j] ? 1 : 0;
        }
        if (dp[i][j][k] != -1) return dp[i][j][k];
        dp[i][j][k] = pathCountWithKcoins(mat, k - mat[i][j], i - 1, j) + pathCountWithKcoins(mat, k - mat[i][j], i, j - 1);
        return dp[i][j][k];

    }
}
