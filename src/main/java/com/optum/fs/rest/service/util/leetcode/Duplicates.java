package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Duplicates {
    public static void main(String[] args) {
        new Duplicates().findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> output = new ArrayList<>();
        int index = 0;
        for(int i =0;i<nums.length;i++){
            index = Math.abs(nums[i])-1;
            if(nums[index] < 0) output.add(index+1);
            nums[index] = -nums[index];
        }
        return output;
    }
}
