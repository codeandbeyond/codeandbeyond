package com.optum.fs.rest.service.util.leetcode;

public class LongestIncreasingContSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 2, 2};
        LongestIncreasingContSubsequence longestIncreasingContSubsequence = new LongestIncreasingContSubsequence();
        longestIncreasingContSubsequence.findLengthOfLCIS(nums);
    }

    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 1;
        int length;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[right] > nums[right-1]) {
                length = right - left + 1;
                if (length > maxLength) {
                    maxLength = length;
                }
            } else {
                length = 1;
                maxLength = Math.max(length,maxLength);
                left = right;

            }
            right++;
        }


        return maxLength;

    }
}
