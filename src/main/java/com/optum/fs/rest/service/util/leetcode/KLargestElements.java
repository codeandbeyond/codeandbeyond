package com.optum.fs.rest.service.util.leetcode;

import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int n = arr.length;
        KLargestElements kLargestElements = new KLargestElements();
        kLargestElements.topKelementsMaxHeap(arr, k);
        kLargestElements.topKelementsMinHeap(arr, k);
    }

    private void topKelementsMaxHeap(int[] arr, int k) {// O(kLog(n))
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (Integer.compare(b, a)));
        for (int num : arr) {
            maxHeap.add(num);
        }
        while (!maxHeap.isEmpty() && k-- > 0) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
    }

    private void topKelementsMinHeap(int[] arr, int k) {// O(kLog(k)+(n-k)*log(k)+k)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (Integer.compare(a, b)));
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        while (!minHeap.isEmpty() && k-- > 0) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}
