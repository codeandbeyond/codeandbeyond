package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(input);

    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<int[]> outPutList = new ArrayList<>();
        int[] currentInterval = intervals[0];
        outPutList.add(currentInterval);
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextBegining = interval[0];
            int nexttEnd = interval[1];

            if (currentEnd >= nextBegining) {
                currentInterval[1] = Math.max(currentEnd, nexttEnd);
            } else {
                currentInterval = interval;
                outPutList.add(currentInterval);
            }

        }
        return outPutList.toArray(new int[outPutList.size()][]);


    }
}
