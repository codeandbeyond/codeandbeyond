package com.optum.fs.rest.service.util.leetcode;



public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int sum = 11;
        int nums[] = {1,2,3,4,5};
        System.out.println(" Minimum Size "+minSubArrayLen(sum,nums));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int right = 0;
        int currSum = 0;
        int minLength = Integer.MAX_VALUE;
        while(right < nums.length){
           currSum+=nums[right];

               while(currSum >= s){
                   minLength = Math.min(minLength,right-start+1);
                   currSum = currSum-nums[start];
                   start++;
               }


           right++;
        }
        return minLength;
    }
}
