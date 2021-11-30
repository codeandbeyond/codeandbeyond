package com.optum.fs.rest.service.util.problems.graphs.leetcode;

import java.util.*;

public class ConnectCitiesWithMinimumCost {
    public int minimumCost(int N, int[][] connections){
        Map<Integer, List<int[]>> map = new HashMap();
        Set<Integer> visited = new HashSet();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        int totalCost = 0;

        for(int[] connection:connections){
            int u = connection[0];
            int v = connection[1];
            int cost = connection[2];

            map.put(u,new ArrayList());
            map.put(v,new ArrayList());

            map.get(u).add(new int[]{v,cost});
            map.get(v).add(new int[]{u,cost});

        }
        minHeap.add(new int[]{1,1,0});
        while(!minHeap.isEmpty()){
            if(visited.size() == N) return totalCost;
            int[] cur = minHeap.poll();
            int u = cur[0];
            int v = cur[1];
            int cost = cur[2];

            if(!visited.contains(v)){
                totalCost+=cost;
                visited.add(v);
                for(int[] next:map.get(v)){
                    minHeap.add(new int[]{v,next[0],next[1]});
                }
            }
        }

        return visited.size() == N?totalCost:-1;
    }

    public static void main(String[] args) {

    }
}
