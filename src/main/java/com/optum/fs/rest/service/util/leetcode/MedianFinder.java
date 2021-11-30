package com.optum.fs.rest.service.util.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private Queue<Integer> MaxHeap;
    private Queue<Integer> MinHeap;

    public MedianFinder() {
        MaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        MinHeap = new PriorityQueue<>();
    }

    public void addItem(int number) {
        if (!MinHeap.isEmpty() && number < MinHeap.peek()) {
            MaxHeap.offer(number);
            if (MaxHeap.size() > MinHeap.size() + 1) {
                MinHeap.offer(MaxHeap.poll());
            }
        } else {
            MinHeap.offer(number);
            if (MinHeap.size() > MaxHeap.size() + 1) {
                MaxHeap.offer(MinHeap.poll());
            }
        }
    }

    public double getMedian() {
        double median;
        if (MinHeap.size() > MaxHeap.size()) {
            median = MinHeap.peek();
        } else if (MaxHeap.size() > MinHeap.size()) {
            median = MaxHeap.peek();
        } else {
            median = (MaxHeap.peek() + MinHeap.peek()) / 2.0;
        }
        return median;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addItem(2);
        medianFinder.addItem(5);
        medianFinder.addItem(7);
        medianFinder.addItem(9);
        System.out.println(medianFinder.getMedian());
    }
}
