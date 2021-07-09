package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.util.Arrays;

public class AttendMeetings {
    public static void main(String[] args) {
        AttendMeetings attendMeetings = new AttendMeetings();
        attendMeetings.canAttendMeetings(new int[][]{{7,10},{2,4}});
    }
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[1]-b[1]);
        int n = intervals.length;
        int i=0;

        while(i<n-1 && intervals[i][1] <= intervals[i+1][0]){
            i++;
        }
        if(i==n-1   ){
            return true;
        }else{
            return false;
        }
    }

}
