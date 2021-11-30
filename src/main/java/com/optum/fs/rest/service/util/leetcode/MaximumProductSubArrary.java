package com.optum.fs.rest.service.util.leetcode;

public class MaximumProductSubArrary {
    public static void main(String[] args) {
        MaximumProductSubArrary maximumProductSubArrary = new MaximumProductSubArrary();
        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println(maximumProductSubArrary.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return -1;

        int currentMax = nums[0];
        int currentMin = nums[0];
        int finalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currentMax;

            currentMax = Math.max(Math.max(currentMax * nums[i], currentMin * nums[i]), nums[i]);

            currentMin = Math.min(Math.min(temp * nums[i], currentMin * nums[i]), nums[i]);

            finalMax = Math.max(currentMax, finalMax);
        }

        return finalMax;

    }
}
