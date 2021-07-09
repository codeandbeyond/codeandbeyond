package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;


import java.util.HashMap;
import java.util.Map;

public class DistinctCountInSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        printSize(arr, k);
    }

    private static void printSize(int[] arr, int k) {
        Map<Integer, Integer> unique = new HashMap<Integer, Integer>();
        int distinctCount = 0;
        for (int i = 0; i < k; i++) {
            if (!unique.containsKey(arr[i])) {
                unique.put(arr[i], 1);
                distinctCount++;
            } else {
                unique.put(arr[i], unique.get(arr[i]) + 1);

            }

        }
        System.out.print(" " + distinctCount);
        for (int i = k; i < arr.length; i++) {
            if (unique.get(arr[i - k]) == 1) {
                unique.remove(arr[i - k]);
                distinctCount--;
            } else {
                unique.put(arr[i - k], unique.get(arr[i - k]) - 1);

            }
            if (!unique.containsKey(arr[i])) {
                unique.put(arr[i], 1);
                distinctCount++;
            } else {
                unique.put(arr[i], unique.get(arr[i]) + 1);

            }
            System.out.print(" " + distinctCount);
        }
    }
}
