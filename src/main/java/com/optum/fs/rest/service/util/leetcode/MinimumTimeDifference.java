package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public static void main(String[] args) {
        MinimumTimeDifference minimumTimeDifference = new MinimumTimeDifference();
        System.out.println(" "+minimumTimeDifference.findMinDifference(Arrays.asList(new String[]{"23:59", "00:00"})));
    }

    public int findMinDifference(List<String> timePoints) {
        int minDifference = Integer.MAX_VALUE;
        boolean[] timeSeeen = new boolean[24 * 60];
        for (String time : timePoints) {
            int hr = Integer.parseInt(time.split(":")[0]);
            int minute = Integer.parseInt(time.split(":")[1]);
            if (timeSeeen[hr * 60 + minute]) return 0;
            timeSeeen[hr * 60 + minute] = true;
        }

        Integer firstTimeSeen = null;
        Integer prevTimeSeen = null;

        for (int i = 0; i < 1440; i++) {
            if (timeSeeen[i]) {
                if (firstTimeSeen == null) {
                    firstTimeSeen = i;
                    prevTimeSeen = i;
                } else {
                    minDifference = Math.min(minDifference, Math.min(i - prevTimeSeen, 1440 - i + prevTimeSeen));
                    prevTimeSeen = i;
                }
            }
        }
        minDifference = Math.min(minDifference, Math.min(prevTimeSeen - firstTimeSeen, 1440 - prevTimeSeen + firstTimeSeen));


        return minDifference;

    }
}
