package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestK {
    public static void main(String[] args) {
        int[] num = {3, 2, -1, 5, -4};
        LargestK largestK = new LargestK();
        largestK.largestNum(num);
        largestK.largestNumSet(num);
    }

    private int largestNum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == 0) {
                result = Math.max(result, Math.abs(nums[l]));
                l++;
                r--;
            } else if (sum < 0) {
                l++;
            } else {
                r--;
            }

        }
        System.out.println("Result " + result);
        return result;
    }
    private int largestNumSet(int[] nums) {
       Set<Integer> set = new HashSet<>();
        int result = 0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(-nums[i]);
            }else{
                result = Math.max(result,Math.abs(nums[i]));
            }
        }

        System.out.println("Result " + result);
        return result!=0?result:0;
    }
}
