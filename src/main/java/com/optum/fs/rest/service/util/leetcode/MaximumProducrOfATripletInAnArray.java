package com.optum.fs.rest.service.util.leetcode;

public class MaximumProducrOfATripletInAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -6, -7, 0};
        int n = arr.length;

        int max = maxProduct(arr, n);

        if (max == -1)
            System.out.println("No Triplet Exists");
        else
            System.out.println("Maximum product is " + max);
    }

    private static int maxProduct(int[] arr, int n) {
        if (n < 3) {
            return -1;
        }
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int maxSum = arr[0];
        int minSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = maxSum;
            if (arr[i] > maxSum) {
                maxSum = arr[i];
            }
            leftMin[i] = minSum;
            if (arr[i] < minSum) {
                minSum = arr[i];
            }
        }
        maxSum = arr[n - 1];
        minSum = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = maxSum;
            if (arr[i] > maxSum) {
                maxSum = arr[i];
            }
            rightMin[i] = minSum;
            if (arr[i] < minSum) {
                minSum = arr[i];
            }
        }
        int max_product = 0;
        for (int i = 1; i < n - 1; i++) {
            int max1 = Math.max(arr[i] * leftMax[i] * rightMax[i],
                    arr[i] * leftMin[i] * rightMin[i]);

            int max2 = Math.max(arr[i] * leftMax[i] * rightMin[i],
                    arr[i] * leftMin[i] * rightMax[i]);

            max_product = Math.max(max_product, Math.max(max1, max2));
        }

        return max_product;

    }
}
