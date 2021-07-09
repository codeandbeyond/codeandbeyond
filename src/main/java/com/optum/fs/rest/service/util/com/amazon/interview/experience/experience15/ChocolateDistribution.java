package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.Arrays;

public class ChocolateDistribution {
    public static void main(String[] args) {
        int arr[] = {12, 4, 7, 9, 2, 23,
                25, 41, 30, 40, 28,
                42, 30, 44, 48, 43,
                50};

        int m = 7;  // Number of students

        int n = arr.length;
        System.out.println("Minimum difference is "
                + findMinDiff(arr, m, n));
    }
    public static int findMinDiff(int[] arr, int numberOfStudents, int numberOfPackets) {
        if (numberOfPackets == 0 || numberOfStudents == 0) {
            return 0;
        }
        if (numberOfStudents > numberOfPackets) {
            return -1;
        }
        Arrays.sort(arr);
        int min_diff = Integer.MAX_VALUE;
        int first = 0;
        int last = 0;
        for (int i = 0; i + numberOfStudents - 1 < numberOfPackets; i++) {
            int diff = arr[i + numberOfStudents - 1] - arr[i];
            if (diff < min_diff) {
                min_diff = diff;
                first = i;
                last = i + numberOfStudents - 1;
            }
        }
        return arr[last] - arr[first];

    }
}
