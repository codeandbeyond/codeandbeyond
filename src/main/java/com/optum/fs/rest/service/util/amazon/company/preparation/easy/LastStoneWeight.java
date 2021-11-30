package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int[] stones = new int[]{2,7,4,1,8,1};
        lastStoneWeight.lastStoneWeight(stones);
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue pq = new PriorityQueue<Integer>((a,b)->b.intValue()-a.intValue());
        for(Integer stone:stones){
            pq.add(stone);
        }
        while(pq.size()>1){
            Integer x = (Integer) pq.remove();
            Integer y = (Integer) pq.remove();
            if(x>y){
                x=x-y;
                pq.add(x);
            }else if(x<y){
               y = y-x;
               pq.add(y);
            }
        }
        return pq.size()==1?(int)pq.remove():0;

    }
}
