package com.optum.fs.rest.service.util.problems.graphs.leetcode;

import java.util.*;

public class ReconstructItenarry {
    Map<String, PriorityQueue<String>> map;
    LinkedList paths;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        paths = new LinkedList();
        for(List<String> ticket:tickets){
            map.putIfAbsent(ticket.get(0),new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return paths;
    }

    private void dfs(String depart) {
        PriorityQueue<String> priorityQueue = map.get(depart);
        while (!priorityQueue.isEmpty()){
            dfs(priorityQueue.poll());
        }
        paths.add(depart);
    }

    public static void main(String[] args) {

    }
}
