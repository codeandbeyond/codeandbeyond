package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.*;

public class PairsOfPositiveNegativeValuesInArray {
    //{4, 8, 9, -4, 1, -1, -8, -9}
    public void printPairs(int nums[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int v = Math.abs(num);
            map.put(v, map.getOrDefault(v, 0) + 1);
            if (map.get(v) == 2) {
                result.add(v);
            }
        }
        Collections.sort(result);
        for(int num:result){
            System.out.print(-num+" "+num+" ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 9, -4, 1, -1, -8, -9};
        PairsOfPositiveNegativeValuesInArray pairsOfPositiveNegativeValuesInArray = new PairsOfPositiveNegativeValuesInArray();
        pairsOfPositiveNegativeValuesInArray.printPairs(nums,nums.length);
    }
}
