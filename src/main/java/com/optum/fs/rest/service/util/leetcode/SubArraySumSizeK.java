package com.optum.fs.rest.service.util.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumSizeK {
    public static void main(String[] args) {
        int[] nums = new int[]{-3, 3};
        int k = 0;
        System.out.println(subarraySum(nums,k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int result = 0;

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
