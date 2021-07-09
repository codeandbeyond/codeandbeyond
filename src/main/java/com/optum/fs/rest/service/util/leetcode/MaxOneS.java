package com.optum.fs.rest.service.util.leetcode;

public class MaxOneS {
    public static void main(String[] args) {
    findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1});
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;

        int maxCount=0;
        while(left <= right){
            int count =0;
            while(left <=right && nums[left]==1 ){
                count++;
                left++;
            }
            maxCount = Math.max(maxCount,count);
            left++;
        }
        return maxCount;
    }
}
