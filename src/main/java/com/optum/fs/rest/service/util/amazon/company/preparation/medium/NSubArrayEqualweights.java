package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NSubArrayEqualweights {
    public  List<List<Integer>> part(int[] nums,int n){
        int sums[] = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(sums[a.intValue()]-sums[b.intValue()]));
        List<List<Integer>> results = new ArrayList<>();
        for(int i=0;i<n;i++){
            results.add(new ArrayList<>());
            pq.add(i);
        }

        for(int i= nums.length-1;i>=0;i--){
            int c = pq.poll();
            results.get(c).add(nums[i]);
            sums[c]+=nums[i];
            pq.add(c);
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int n = 3;
        NSubArrayEqualweights nSubArrayEqualweights = new NSubArrayEqualweights();
        nSubArrayEqualweights.part(nums,n);
    }
}
