package com.optum.fs.rest.service.util.leetcode;

public class FindStartAndEndBinarySearch {
    public static void main(String[] args) {
        FindStartAndEndBinarySearch find = new FindStartAndEndBinarySearch();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int start = find.findStartingIndex(nums, 8);
        int end = find.endStartingIndex(nums, 8);
        System.out.println(" Start"+start + " End "+end);
    }

    public int findStartingIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    public int endStartingIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }
}
