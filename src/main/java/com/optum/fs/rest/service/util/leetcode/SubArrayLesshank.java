package com.optum.fs.rest.service.util.leetcode;

public class SubArrayLesshank {


    public static void main(String[] args) {
        SubArrayLesshank subArrayLesshank = new SubArrayLesshank();
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        subArrayLesshank.numSubarrayProductLessThanK(nums, k);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int prod = 1;
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < nums.length) {
            prod = prod * nums[right];
            while (prod >= k) {
                prod = prod / nums[left];
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }
}
