package com.optum.fs.rest.service.util.leetcode;

import java.util.PriorityQueue;

public class ConnectRopes {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        ConnectRopes connectRopes = new ConnectRopes();
        connectRopes.minCost(arr);
    }

    private void minCost(int[] arr) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int minCost = 0;
            for (Integer length : arr) {
                pq.add(length);
            }
            while (pq.size() > 1) {
                int first = pq.poll();
                int second = pq.poll();
                minCost += first + second;
                pq.add(first + second);
            }
        System.out.println("Minimum cost " + minCost);
    }
}
