package com.optum.fs.rest.service.util.leetcode;

public class SubsetSumPartionMinimum {
    public static void main(String[] args) {
        int[] arr = {7, 4, 1};
        SubsetSumPartionMinimum subsetSumPartionMinimum = new SubsetSumPartionMinimum();
        System.out.println(subsetSumPartionMinimum.findMin(arr));
    }

    private int findMin(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int num : arr) {
            sum += num;
        }
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int j = 0; j <= sum; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i][j] | dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }
}
