package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.HashMap;
import java.util.Map;

public class MaximumZeroSum {
    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of the longest 0 sum subarray is "
                + maxLen(arr));
    }

    private static int maxLen(int[] arr) {
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> sumIndexMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0 && maxLength == 0) {
                maxLength = 1;
            }
            if (sum == 0) {
                maxLength = i + 1;
            }
            Integer prevIndex = sumIndexMap.get(sum);
            if (prevIndex != null) {
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                sumIndexMap.put(sum, i);
            }
        }
        return maxLength;
    }
}
