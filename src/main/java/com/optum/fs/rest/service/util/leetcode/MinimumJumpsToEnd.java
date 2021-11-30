package com.optum.fs.rest.service.util.leetcode;

/**
 * Created by Ashok on 01-06-2020.
 */
public class MinimumJumpsToEnd {
    public static void main(String[] args) {
        int arr[] = {1,4,3,2,6,7};
        int n = arr.length;
        System.out.println(" Can jump to end?? " + canJump(arr));

    }

    private static boolean canJump(int[] arr) {
        int n = arr.length;
        int count = 0;
        int lastGoodPosition = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i + arr[i] >= lastGoodPosition) {
                lastGoodPosition = i;
                count++;
            }
        }
        System.out.println(count);
        return lastGoodPosition == 0;
    }
}
