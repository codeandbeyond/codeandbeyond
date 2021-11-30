package com.optum.fs.rest.service.util.twilio.company.preparation;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumDivisbleByk {
    public static void main(String[] args) {
       int[] nums = {4,5,0,-2,-3,1} ;
       int k = 5;
        System.out.println(new SubArraySumDivisbleByk().subarraysDivByK(nums,k));
    }
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        int right = 0;
        int sum = 0;
        map.put(0,1);
        int result = 0;
        while(right<nums.length){
            sum = (sum+nums[right])%k;
            if(sum<0) sum+=k;
            if(map.containsKey(sum)){
                result+=map.get(sum);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
            right++;
        }
        return result;
    }
}
