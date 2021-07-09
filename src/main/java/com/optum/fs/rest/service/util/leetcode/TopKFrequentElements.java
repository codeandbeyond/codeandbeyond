package com.optum.fs.rest.service.util.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = { 2, 23, 12, 9, 30, 2, 1 };
        int n = arr.length;
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        topKFrequentElements.topKelements(arr,k,n);
    }

    private void topKelements(int[] arr, int k, int n) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num :arr){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        priorityQueue.addAll(freqMap.entrySet());
        while (!priorityQueue.isEmpty()&&k-- > 0){
            System.out.print(priorityQueue.poll().getKey()+" ");
        }
    }
}
