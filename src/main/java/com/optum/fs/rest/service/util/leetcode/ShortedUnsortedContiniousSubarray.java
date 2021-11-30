package com.optum.fs.rest.service.util.leetcode;

public class ShortedUnsortedContiniousSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        ShortedUnsortedContiniousSubarray shortedUnsortedContiniousSubarray = new ShortedUnsortedContiniousSubarray();
        shortedUnsortedContiniousSubarray.findUnsortedSubarray(nums);
    }

    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        boolean flag = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            }

            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }

            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }
        int l = 0, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min < nums[i]) {
                l = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (max > nums[i]) {
                r = i;
                break;
            }
        }
        return (r - l > 0) ? (r - l + 1) : 0;

    }
}
