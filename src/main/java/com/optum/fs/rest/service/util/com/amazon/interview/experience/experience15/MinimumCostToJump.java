package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.Arrays;

public class MinimumCostToJump {
    public static void main(String[] args) {
        int []arr={10,50,40};
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp,-1);
        System.out.println(" "+minCostJumpdp(arr,0,arr.length-1,dp));
    }
    public static int minCostJump(int costarr[],int index,int N){
        if(index == N)
            return 0;
        int left = Math.abs(costarr[index] -costarr[index+1])+minCostJump(costarr,index+1,N);
        int right = Integer.MAX_VALUE;

        if(index+2<=N){
            right =  Math.abs(costarr[index] -costarr[index+2])+minCostJump(costarr,index+2,N);
        }
        return Math.min(left,right);
    }
    public static int minCostJumpdp(int costarr[],int index,int N,int dp[]){

        if(index == N)
            return 0;
        if(dp[index]!=-1){
            return dp[index];
        }
        int left = Math.abs(costarr[index] -costarr[index+1])+minCostJump(costarr,index+1,N);
        int right = Integer.MAX_VALUE;

        if(index+2<=N){
            right =  Math.abs(costarr[index] -costarr[index+2])+minCostJump(costarr,index+2,N);
        }
        dp[index] = Math.min(left,right);
        return dp[index];
    }
}
