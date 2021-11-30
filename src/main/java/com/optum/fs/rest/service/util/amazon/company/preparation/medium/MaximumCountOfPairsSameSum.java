package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumCountOfPairsSameSum {
    public static void main(String[] args) {
        int[] nums = {1, 8, 3, 11, 4, 9, 2, 7};
        MaximumCountOfPairsSameSum maximumCountOfPairsSameSum = new MaximumCountOfPairsSameSum();
        int res = maximumCountOfPairsSameSum.maxCountOfPairs(nums);
        System.out.println(res);
    }
    public int maxCountOfPairs(int[] nums){
        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum = nums[i]+nums[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
                max = Math.max(max,map.get(sum));
            }
        }
        return max;
    }
}
