package com.optum.fs.rest.service.util.leetcode;

public class FindMaximumSUMExclusive {
    public static void main(String[] args) {
        FindMaximumSUMExclusive findMaximumSUMExclusive = new FindMaximumSUMExclusive();
        int[] nums = new int[]{5, 5, 10, 40, 50, 35};
        System.out.println(findMaximumSUMExclusive.maxSumExclusive(nums));
    }

    public int maxSumExclusive(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];

    }
}
