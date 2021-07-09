package com.optum.fs.rest.service.util.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {
    public static void main(String[] args) {
        DegreeOfArray degreeOfArray = new DegreeOfArray();
        int[] nums = new int[]{1, 2, 2, 3, 1, 4, 2};
        degreeOfArray.findShortestSubArray(nums);
    }

    public int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> seenMap = new HashMap<>();

        int minLength = Integer.MAX_VALUE;
        int degree = 0;

        for (int i = 0; i < nums.length; i++) {
            seenMap.putIfAbsent(nums[i], i);
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            if (countMap.get(nums[i]) > degree) {
                degree = countMap.get(nums[i]);
                minLength = i - seenMap.get(nums[i]) + 1;
            } else if (countMap.get(nums[i]) == degree) {
                minLength = Math.min(minLength, i - seenMap.get(nums[i]) + 1);
            }
        }
        return minLength;

    }
}
