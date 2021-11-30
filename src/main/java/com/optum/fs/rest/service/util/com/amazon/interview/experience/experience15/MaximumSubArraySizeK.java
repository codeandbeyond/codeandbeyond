package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumSubArraySizeK {
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
       printKmax(arr, arr.length, k);
        MaximumSubArraySizeK maximumSubArraySizeK = new MaximumSubArraySizeK();
        maximumSubArraySizeK.printKmaxDifferent(arr, k);

    }

    public static void printKmax(int[] arr, int n, int k) {
        int max = 0;
        for (int i = 0; i <= n - k; i++) {
            max = arr[i];
            for (int j = 1; j < k; j++) {
                if (arr[i + j] > max) {
                    max = arr[i + j];
                }
            }
            System.out.print(" " + max);
        }

    }

    public void printKmaxDifferent(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window) elements of array */
        int i;
        for (i = 0; i < k; ++i) {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast(); // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);

    }
}
