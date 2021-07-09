package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AverageScore {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> priorityQueueMap = new HashMap<>();

        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            PriorityQueue<Integer> pq;
            if (!priorityQueueMap.containsKey(id)) {
                pq = new PriorityQueue<>(5);
                pq.offer(score);
            } else {
                pq = priorityQueueMap.get(id);
                pq.offer(score);
                if (pq.size() > 5) {
                    pq.poll();
                }
            }
            priorityQueueMap.put(id, pq);
        }
        int[][] result = new int[priorityQueueMap.size()][2];
        int index = 0;
        for (Integer id : priorityQueueMap.keySet()) {
            result[index][0] = id;
            PriorityQueue<Integer> pq = priorityQueueMap.get(id);
            int res = 0;
            while (!pq.isEmpty()) {
                res += pq.poll();
            }
            result[index][1] = res / 5;
        }
        return result;
    }
}
