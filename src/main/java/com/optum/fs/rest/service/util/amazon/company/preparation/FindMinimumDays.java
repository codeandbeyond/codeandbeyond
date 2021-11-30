package com.optum.fs.rest.service.util.amazon.company.preparation;

public class FindMinimumDays {
    public static void main(String[] args) {
        System.out.println(findMinDays(3,4));
    }
    static int findMinDays(int n, int m) {
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = i-1;
        }
        return minimumSteps(n,dp,m);
    }
    static int minimumSteps(int n,int[] dp,int m){
        if(n==1){
            if(m==1) return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int res = minimumSteps(n-1,dp,m);
        if(m<=n/2){
            res = Math.min(res,minimumSteps(n/2,dp,m));
        }
        dp[n] = 1+res;
        return dp[n];
    }
}
