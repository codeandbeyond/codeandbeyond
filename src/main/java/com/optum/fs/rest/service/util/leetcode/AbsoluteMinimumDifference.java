package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbsoluteMinimumDifference {
    public static void main(String[] args) {
        AbsoluteMinimumDifference absoluteMinimumDifference = new AbsoluteMinimumDifference();
        int[] nums = new int[]{3, 8, -10, 23, 19, -4, -14, 27};
        absoluteMinimumDifference.minimumAbsDifference(nums);

    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> outputList = new ArrayList<>();

        Arrays.sort(arr);
        int minDifference = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            minDifference = Math.min(arr[i] - arr[i - 1], minDifference);
        }

        for (int i = 1; i < arr.length; i++) {
            if (minDifference == arr[i] - arr[i - 1]) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                outputList.add(pair);

            }
        }
        return outputList;


    }

}

