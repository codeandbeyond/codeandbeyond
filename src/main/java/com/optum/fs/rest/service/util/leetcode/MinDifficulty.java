package com.optum.fs.rest.service.util.leetcode;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.util.Arrays;
import java.util.Date;

public class MinDifficulty {
    private static final DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder()
            .appendYear(4,4).appendMonthOfYear(2).appendDayOfMonth(2).toFormatter();
    public static void main(String[] args) {
        MinDifficulty minDifficulty = new MinDifficulty();
        int[] job= {6,5,4,3,2,1};
        int days= 2;
        System.out.println(minDifficulty.minDifficulty(job,days));

        Date date = DATE_FORMATTER.parseDateTime("20201221").toDate();
        System.out.println(date.toString());
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n<d ) return -1;
        int[] dp = new int[n+1];
       for(int i = n-1;i>=0;i--){
           dp[i] = Math.max(dp[i+1],jobDifficulty[i]);
       }
        for(int day = 2;day<=d;day++){
            for(int i =0;i<=n-day;i++){
                dp[i] = Integer.MAX_VALUE;
               int maxd = 0;
                for(int j=i;j<=n-day;j++){
                    maxd = Math.max(maxd,jobDifficulty[j]);
                    dp[i] = Math.min(dp[i],maxd+dp[j+1]);
                }
            }
        }
        return dp[0];
    }
}
