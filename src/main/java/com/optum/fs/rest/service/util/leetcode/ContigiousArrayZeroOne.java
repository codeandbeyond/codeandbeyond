package com.optum.fs.rest.service.util.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContigiousArrayZeroOne {
    public static void main(String[] args) {
        ContigiousArrayZeroOne contigiousArrayZeroOne = new ContigiousArrayZeroOne();
        int[] nums = new int[]{0, 1, 0};
        System.out.println(contigiousArrayZeroOne.findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> countIndexMap = new HashMap<>();
        countIndexMap.put(0, -1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }
            if (countIndexMap.containsKey(count)) {
                maxLength = Math.max(maxLength, i - countIndexMap.get(count));
            } else {
                countIndexMap.put(count, i);
            }

        }
        return maxLength;
    }
}
