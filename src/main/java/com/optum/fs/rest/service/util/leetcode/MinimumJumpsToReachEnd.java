package com.optum.fs.rest.service.util.leetcode;

public class MinimumJumpsToReachEnd {
    public static void main(String[] args) {
        MinimumJumpsToReachEnd minimumJumpsToReachEnd = new MinimumJumpsToReachEnd();
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minimumJumpsToReachEnd.findMinJumps(arr));
    }

    private int findMinJumps(int[] arr) {
        int maxReach = arr[0];
        int steps = arr[0];
        int jump = 1;
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) {
                return jump;
            }
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;
            if (steps == 0) {
                jump++;
                if (i >= maxReach) return -1;
                steps = maxReach - i;
            }
        }
        return -1;
    }
}
