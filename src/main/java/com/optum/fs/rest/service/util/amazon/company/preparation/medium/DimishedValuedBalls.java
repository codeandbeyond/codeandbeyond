package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.PriorityQueue;

public class DimishedValuedBalls {
    class Pair{
        int type;
        int count;
        Pair(int type,int count){
            this.type = type;
            this.count = count;
        }
    }
    public int maxProfit(int[] inventory, int orders) {
        int maxProfit = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->(b.count-a.count));
        for(int i=0;i<inventory.length;i++){
            Pair p = new Pair(i,inventory[i]);
            pq.add(p);
        }

        while(!pq.isEmpty() && orders > 0){
            Pair currPair = pq.poll();
            maxProfit+=currPair.count;
            currPair.count--;
            pq.add(currPair);
            orders--;
        }
        return (int)maxProfit%1000000007;
    }

    public static void main(String[] args) {
        int[]  inventory = {1000000000};
        int orders = 1000000000;
        DimishedValuedBalls dimishedValuedBalls = new DimishedValuedBalls();
        System.out.println(dimishedValuedBalls.maxProfit(inventory,orders));
    }
}
