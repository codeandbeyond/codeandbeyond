package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
    }
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0]+nums[1]+nums[nums.length-1];
        Arrays.sort(nums);
        for(int i=0;i< nums.length-2;i++){
            int lo = i+1;
            int hi = nums.length-1;
            while (lo < hi){
                int sum = nums[i]+nums[lo]+nums[hi];
                if(Math.abs(sum-target) < Math.abs(result-target)){
                    result = sum;
                }
                if(sum > target){
                    hi--;
                }else{
                    lo++;
                }
            }
        }
        return result;
    }
}
