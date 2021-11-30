package com.optum.fs.rest.service.util.leetcode;

public class CountIterations {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 0, 1, 0, 0,
                0, 0, 0, 0, 0, 1, 0};
        CountIterations countIterations = new CountIterations();
        System.out.println(countIterations.countIterations(nums, nums.length));

    }

    public int countIterations(int[] nums, int n) {
        int maxResult = Integer.MIN_VALUE;
        int i = 0;
        int countZero = 0;
        while (i < n) {

            boolean foundOne = false;

            if (nums[i] == 1) {
                foundOne = true;
            }
            while (i < n && nums[i] == 1) {
                i++;
            }
            while (i < n && nums[i] == 0) {
                countZero++;
                i++;
            }
            if (!foundOne && i == n) {
                return -1;
            }
            int currentIteration = 0;
            if (i < n && foundOne) {
                if (countZero % 2 == 0) {
                    currentIteration = countZero / 2;
                } else {
                    currentIteration = (countZero + 1) / 2;
                }
            } else {
                currentIteration = countZero;
            }
            countZero = 0;
            maxResult = Math.max(currentIteration, maxResult);
        }

        return maxResult;
    }
}
