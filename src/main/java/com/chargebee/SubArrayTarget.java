package com.chargebee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayTarget {

    static List<List<Integer>> result = new ArrayList();

    public void getSumTarget(int[] nums, int targetSum, List<Integer> currList,int index) {
        if(targetSum<0) return;

        if (0 == targetSum) {
            result.add(new ArrayList<>(currList));
            return;
        }

        while(index<nums.length && targetSum-nums[index]>=0){
            currList.add(nums[index]);
            getSumTarget(nums, targetSum-nums[index], currList, index+1);
            index++;
            currList.remove(currList.size() - 1);

        }
    }

    public static void main(String[] args) {
        SubArrayTarget subArrayTarget = new SubArrayTarget();
        int[] arr = {1, 3, 2, 5, 4, 6};
        int target = 10;
        Arrays.sort(arr);
       subArrayTarget.getSumTarget(arr, target, new ArrayList<>(),0);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
