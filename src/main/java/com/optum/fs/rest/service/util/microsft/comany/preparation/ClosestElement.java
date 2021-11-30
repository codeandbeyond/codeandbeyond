package com.optum.fs.rest.service.util.microsft.comany.preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestElement {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]));
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            int diff = Math.abs(x-num);
            pq.add(new int[]{diff,num});
        }

        List<Integer> list = new ArrayList();
        while(!pq.isEmpty() && k-- > 0){
            int[] pair = pq.poll();
            list.add(pair[1]);
        }

        return list;
    }

    public List<Integer> findClosestElement(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length-1;
        while(hi-lo >= k){
            if(Math.abs(arr[lo]-x) > Math.abs(arr[hi]-x)){
                lo++;
            }else{
                hi--;
            }
        }

        List<Integer> list = new ArrayList(k);
       for(int i=lo;i<=hi;i++) {
           list.add(arr[i]);
       }
        return list;
    }

    public static void main(String[] args) {
      int[] arr =  {1,2,3,4,5};
       int k= 4;
       int x= 3;
       ClosestElement closestElement = new ClosestElement();
       closestElement.findClosestElement(arr,k,x);
    }
}
