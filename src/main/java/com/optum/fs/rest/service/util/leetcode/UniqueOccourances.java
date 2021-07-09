package com.optum.fs.rest.service.util.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccourances {
    public static void main(String[] args) {
        UniqueOccourances uniqueOccourances = new UniqueOccourances();
        int[] nums = new int[]{26, 2, 16, 16, 5, 5, 26, 2, 5, 20, 20, 5, 2, 20, 2, 2, 20, 2, 16, 20, 16, 17, 16, 2, 16, 20, 26, 16};
        uniqueOccourances.uniqueOccurrences(nums);
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countUnique = new HashMap<>();
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            countUnique.put(arr[i], countUnique.getOrDefault(arr[i], 0) + 1);
        }

        for (Integer num : countUnique.keySet()) {
            int freq = countUnique.get(num);
            if (unique.contains(freq)) {
                return false;
            }
            unique.add(freq);
        }
        return true;
    }
}
