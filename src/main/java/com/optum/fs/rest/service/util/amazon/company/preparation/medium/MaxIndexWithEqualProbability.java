package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MaxIndexWithEqualProbability {
    public static void main(String[] args) {
        MaxIndexWithEqualProbability maxIndexWithEqualProbability = new MaxIndexWithEqualProbability();
        int[] arr = {-1, 4, 9, 7, 7, 2, 7, 3, 0, 9, 6, 5, 7, 8, 9};
        System.out.println(maxIndexWithEqualProbability.findRandomIndexOfMax(arr,arr.length));
    }
    public int findRandomIndexOfMax(int arr[], int n){
        int maxFreq = Integer.MIN_VALUE;
        int maxElement = 0;
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            if(entry.getValue()>maxFreq){
                maxFreq = entry.getValue();
                maxElement = entry.getKey();
            }
        }

        int count =0;
        int r = (new Random().nextInt(maxFreq)%maxFreq)+1;

        int ans = -1;

        for(int i=0;i<arr.length;i++){
            if(arr[i] == maxElement){
                count++;
            }

            if(count == r){
                ans = i;
                break;
            }
        }
        return ans;
    }
}
