package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum {
   static List<List<Integer>> solution = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int []arr ={2,7,6,3,5,1};

        int sum =9;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<Integer>();

        combinationalSum(arr,sum,list,0);
      for(int j=0;j<solution.size();j++){
          for(int k=0;k<solution.get(j).size();k++){
              System.out.print(solution.get(j).get(k)+"  ");
          }
          System.out.println();
      }

    }

    private static void combinationalSum(int[] arr, int sum, List<Integer> list,int i) {
        if(sum<0)
            return;
        if(sum ==0){
            solution.add(new ArrayList<Integer>(list));
            return;
        }
        while (i<arr.length && sum-arr[i]>=0){
            list.add(arr[i]);
            combinationalSum(arr,sum-arr[i],list,i);
            i++;
            list.remove(list.size()-1);
        }

    }
}
