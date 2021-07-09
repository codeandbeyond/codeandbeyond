package com.optum.fs.rest.service.util.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindSmallestRange {
    class QItem {
        int i;
        int j;
        int val;

        public QItem(int i, int j, int data) {
            this.val = data;
            this.i = i;
            this.j = j;
        }
    }

    class ItemComparator implements Comparator<QItem> {

        @Override
        public int compare(QItem o1, QItem o2) {
            if (o1.val < o2.val) return -1;
            else if (o1.val > o2.val) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        int arr[][] = {
                {4, 7, 9, 12, 15},
                {0, 8, 10, 14, 20},
                {6, 12, 16, 30, 50}
        };

        int k = arr.length;
        FindSmallestRange findSmallestRange = new FindSmallestRange();
        findSmallestRange.findMinRange(arr, k);

    }

    public int findMinRange(int[][] nums, int k) {
        int minRange = Integer.MAX_VALUE;
        int minValue;
        int maxValue = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        PriorityQueue<QItem> priorityQueue = new PriorityQueue<>(k, new ItemComparator());
        for (int i = 0; i < k; i++) {
            QItem qItem = new QItem(i, 1, nums[i][0]);
            priorityQueue.add(qItem);
            maxValue = Math.max(nums[i][0], maxValue);
        }
        while (true) {
            QItem root = priorityQueue.poll();

            minValue = root.val;
            if (maxValue - minValue < minRange) {
                minRange = maxValue - minValue;
                start = maxValue;
                end = minValue;
            }

            if (root.j < nums[0].length) {
                int element = nums[root.i][root.j];
                maxValue = Math.max(element, maxValue);
                root.j = root.j + 1;
            } else
                break;

            priorityQueue.offer(new QItem(root.i,root.j,nums[root.i][root.j]));

        }
        System.out.println(" START : " + start + " END " + end);
        return minRange;
    }
}
