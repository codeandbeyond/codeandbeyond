package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesInArray {
    public static void main(String[] args) {
        DuplicatesInArray duplicatesInArray = new DuplicatesInArray();
        duplicatesInArray.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] < 0){
                result.add(Math.abs(index+1));
            }
            nums[index] = -nums[index];
        }
        return result;
    }
}
