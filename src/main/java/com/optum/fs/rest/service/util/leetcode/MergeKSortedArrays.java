package com.optum.fs.rest.service.util.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    class HeapNode {
        int rowValue;
        int colValue;
        int value;

        HeapNode(int rowValue, int colValue, int value) {
            this.rowValue = rowValue;
            this.colValue = colValue;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};
        MergeKSortedArrays mergeKSortedArrays = new MergeKSortedArrays();
        mergeKSortedArrays.merge(arr);
    }

    private void merge(int[][] arr) {
        PriorityQueue<HeapNode> priorityQueue = new PriorityQueue<>(new Comparator<HeapNode>() {
            @Override
            public int compare(HeapNode o1, HeapNode o2) {
                return o1.value - o2.value;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(new HeapNode(i, 1, arr[i][0]));
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            HeapNode root = priorityQueue.poll();
            resultList.add(root.value);
            if (root.colValue < arr[root.rowValue].length) {
                root.value = arr[root.rowValue][root.colValue];
                (root.colValue)++;
            } else {
                root.value = Integer.MAX_VALUE;
            }
            if (root.value != Integer.MAX_VALUE)
                priorityQueue.add(root);
        }
        System.out.println(resultList);
    }
}
