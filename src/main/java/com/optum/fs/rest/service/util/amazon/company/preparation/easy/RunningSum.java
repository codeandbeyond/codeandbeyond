package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

public class RunningSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        RunningSum runningSum = new RunningSum();

        for (int num : runningSum.runningSum(nums)) {
            System.out.println(num);
        }
    }

    public int[] runningSum(int[] nums) {
        int[] results = new int[nums.length];
        if (nums.length == 0) return results;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            results[i] = sum;
        }

        return results;

    }
}
