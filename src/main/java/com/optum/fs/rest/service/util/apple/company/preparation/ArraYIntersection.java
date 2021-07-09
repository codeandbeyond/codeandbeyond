package com.optum.fs.rest.service.util.apple.company.preparation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraYIntersection {
    public static void main(String[] args) {
        int nums1[] ={1,2,2,1};
        int nums2[]  = {2,2};
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        for(int num:nums1){
            set.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for(int num:nums2){
            if(set.contains(num)){
               result.add(num);
            }
        }
        int[] sol = new int[result.size()];
        for(int i=0;i<result.size();i++){
            sol[i] = result.get(i);
        }
        return sol;
    }
}
