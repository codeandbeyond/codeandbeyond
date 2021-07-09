package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumbers {
    public static void main(String[] args) {
        MissingNumbers missingNumbers = new MissingNumbers();
        missingNumbers.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList();
       for(int i=0;i<nums.length;i++){
           if(nums[i]!=0 && nums[nums[i]-1]!=0){
               nums[nums[i]-1]=0;
           }
       }
        return result;
    }
}
