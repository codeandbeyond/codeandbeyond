package com.optum.fs.rest.service.util.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {
    public static void main(String[] args) {
        int[] arr = new int[]{10,13,12,14,15};
        System.out.println(oddEvenJumps(arr));
    }

    public static int oddEvenJumps(int[] arr) {
        int n = arr.length;

        int goodStartingIndex = 1;
        Map<Integer, Integer> treeMap = new TreeMap<>();

        boolean[] lower = new boolean[n];
        boolean[] higher = new boolean[n];

        treeMap.put(arr[n - 1], n - 1);

        lower[n - 1] = true;
        higher[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            Map.Entry lowerKeyValuePair = ((TreeMap<Integer, Integer>) treeMap).floorEntry(arr[i]);
            Map.Entry higherKeyValuePair = ((TreeMap<Integer, Integer>) treeMap).ceilingEntry(arr[i]);

            if (higherKeyValuePair != null) {
                higher[i] = lower[(int) higherKeyValuePair.getValue()];
            }
            if (lowerKeyValuePair != null) {
                lower[i] = higher[(int) lowerKeyValuePair.getValue()];
            }
            if (higher[i]) {
                goodStartingIndex++;
            }
            treeMap.put(arr[i], i);
        }
        return goodStartingIndex;

    }
}
