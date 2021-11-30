package com.glovo;

public class MaxSubArraySum {
    public int maxSubArraySum(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        if (k == 0) return 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int left = 0;
        int right = 0;
        int counter = 1;
        while (right < arr.length) {
            if (counter > k) {
                currSum = currSum - arr[left];
                left++;
                counter--;
            }

            currSum = Math.max(currSum + arr[right], arr[right]);
            maxSum = Math.max(currSum, maxSum);

            right++;
            counter++;
        }
        System.out.println("MAxSum : " + maxSum);
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        int[] array = {1, 2, 5, 3, 8, 1, 5};
        int k = 2;
        maxSubArraySum.maxSubArraySum(array, k);
//        Examples:
//
////        1. maxSubarraySum([1, 2, 5, 3, 8, 1, 5], 4) returns 18 (for subarray [2, 5, 3, 8])
////
////        2. maxSubarraySum([1, 2, 5, 3, 8, 1, 5], 2) returns 11 (for subarray [3, 8])
////
////        3. maxSubarraySum([], 4) returns null
    }
}
