package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallestNumbers {
    public static void main(String[] args) {
        SmallestNumbers smallestNumbers = new SmallestNumbers();
        int[] nums= {8,1,2,3,2,4};
        smallestNumbers.smallerNumbersThanCurrent(nums);
    }
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int [] bucket = new int[101];
        for(int i=0;i<nums.length;i++){
            bucket[nums[i]]++;
        }
        for(int i=1;i<count.length;i++){
            count[i] = count[i-1]+bucket[i-1];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = count[nums[i]];
        }
        return nums;
    }
}
