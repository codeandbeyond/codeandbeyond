package com.optum.fs.rest.service.util.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public static void main(String[] args) {
    int[] nums = new int[]{36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42  };
        LongestConsecutive longestConsecutive= new LongestConsecutive();
        System.out.println(longestConsecutive.longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {

        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for(Integer num : nums){
            set.add(num);
        }
        for(Integer num:set){
            if(!set.contains(num-1)){
                int curr = num;
                int count =1;
                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                longest = Math.max(count,longest);
            }
        }
        return longest;
    }
}
