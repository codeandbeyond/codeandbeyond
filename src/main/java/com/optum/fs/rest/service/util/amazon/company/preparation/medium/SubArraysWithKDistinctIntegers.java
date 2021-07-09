package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDistinctIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysWithAtMostKDistinct(A, K) - subarraysWithAtMostKDistinct(A, K - 1);
    }

    private int subarraysWithAtMostKDistinct(int[] a, int k) {
        if(k==0) return 0;
        int numOfGoodSubArrays = 0;
        int j=0;
        int n = a.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(;j<n;j++){
                map.put(a[j],map.getOrDefault(a[j],0)+1);
                if(map.size()<=k){
                    numOfGoodSubArrays+=(j-i+1);
                }else{
                    map.put(a[j],map.get(a[j])-1);
                    if(map.get(a[j])==0){
                        map.remove(a[j]);
                        break;
                    }
                }
            }
            map.put(a[i],map.get(a[i])-1);
            if(map.get(a[i])==0){
                map.remove(a[i]);
            }
        }
        return numOfGoodSubArrays;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        int k = 1;
        SubArraysWithKDistinctIntegers subArraysWithKDistinctIntegers = new SubArraysWithKDistinctIntegers();
        int result = subArraysWithKDistinctIntegers.subarraysWithKDistinct(arr,k);
        System.out.println(result);
    }
}
