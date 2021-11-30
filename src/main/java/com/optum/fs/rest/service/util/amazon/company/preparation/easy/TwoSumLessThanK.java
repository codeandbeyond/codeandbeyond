package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.util.Arrays;

public class TwoSumLessThanK {
    public static void main(String[] args) {
        TwoSumLessThanK twoSumLessThanK = new TwoSumLessThanK();
        int[] nums= new int[]{254,914,110,900,147,441,209,122,571,942,136,350,160,127,178,839,201,386,462,45,735,467,153,415,875,282,204,534,639,994,284,320,865,468,1,838,275,370,295,574,309,268,415,385,786,62,359,78,854,944};
        twoSumLessThanK.twoSumLessThanK(nums,200);
    }
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int a = 0;
        int b = nums.length-1;
        int result = Integer.MIN_VALUE;
        while(a<b){
            int sum = nums[a]+nums[b];
            if(sum > k){
                b--;
            }else if(sum<k){
                result = Math.max(result,sum);
                a++;
            }else{
                a++;
                b--;
            }
        }
        return result==Integer.MIN_VALUE?-1:result;
    }
}
