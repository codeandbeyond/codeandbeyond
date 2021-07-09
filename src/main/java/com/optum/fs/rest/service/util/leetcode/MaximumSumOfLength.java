package com.optum.fs.rest.service.util.leetcode;

public class MaximumSumOfLength {
    public static void main(String[] args) {
        int arr[] = {4, 5, 7, 1, 2, 9, 8, 4, 3, 1};
        int size = arr.length;
        int k = 4;
        MaximumSumOfLength maximumSumOfLength = new MaximumSumOfLength();
        System.out.println(maximumSumOfLength.calculateMaxSumLength(arr, size, k));

    }

    private int calculateMaxSumLength(int arr[], int n, int k) {
        int ans = 0;

        int i = 0;
        while (i < n) {
            int count = 0;
            boolean foundK = false;
            ;
            while (i < n && arr[i] <= k) {
                if (arr[i] == k) {
                    foundK = true;
                }
                count++;
                i++;
            }
            if (foundK) {
                ans += count;
            }
            while (i < n && arr[i] > k) {
                i++;
            }

        }
        return ans;
    }
}
