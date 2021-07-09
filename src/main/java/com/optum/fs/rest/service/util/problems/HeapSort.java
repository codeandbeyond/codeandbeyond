package com.optum.fs.rest.service.util.problems;


/******************************************************************************
 *  Compilation:  javac Heap.java
 *  Execution:    java Heap < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/24pq/tiny.txt
 *                https://algs4.cs.princeton.edu/24pq/words3.txt
 *
 *  Sorts a sequence of strings from standard input using heapsort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Heap < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Heap < words3.txt
 *  all bad bed bug dad ... yes yet zoo   [ one string per line ]
 *
 ******************************************************************************/

import java.util.Scanner;

/**
 * The {@code Heap} class provides a static method to sort an array
 * using <em>heapsort</em>.
 * <p>
 * This implementation takes &Theta;(<em>n</em> log <em>n</em>) time
 * to sort any array of length <em>n</em> (assuming comparisons
 * take constant time). It makes at most
 * 2 <em>n</em> log<sub>2</sub> <em>n</em> compares.
 * <p>
 * This sorting algorithm is not stable.
 * It uses &Theta;(1) extra memory (not including the input array).
 * <p>
 * For additional documentation, see
 * <a href="https://algs4.cs.princeton.edu/24pq">Section 2.4</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class HeapSort {

    // This class should not be instantiated.
    private HeapSort() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param pq the array to be sorted
     */
    public static void sort(Comparable[] pq) {
        int n = pq.length;
        maxHeapify(pq, n);


        // sortdown phase
        int k = n;
        while (k > 1) {
            exch(pq, 1, k--);
            sink(pq, 1, k);
        }
    }

    private static void maxHeapify(Comparable[] pq, int n) {
        // heapify phase
        for (int k = n / 2; k >= 1; k--)
            sink(pq, k, n);
    }

    private static void minHeapify(Comparable[] pq, int n) {
        // heapify phase
        for (int k = n / 2; k >= 1; k--)
            minHeapsink(pq, k, n);
    }

    private static void minHeapsink(Comparable[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j + 1, j)) j++;
            if (!less(pq, j, k)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

    private static void sink(Comparable[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for comparisons and swaps.
     * Indices are "off-by-one" to support 1-based indexing.
     ***************************************************************************/
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }

    private static void exchange(Object[] pq, int i, int j) {
        Object swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    /**
     * Reads in a sequence of strings from standard input; heapsorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = new Integer[]{16, 17, 12, 34, 21, 98, 43, 27, 49, 32, 83, 47, 912, 37, 190};
        runningMedian();
        HeapSort.sort(a);
        show(a);
    }

    private static void runningMedian() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Comparable[] a = new Comparable[n];
        Comparable[] minHeap = new Comparable[n];
        Comparable[] maxHeap = new Comparable[n];
        int minHeapSize = 0;
        int maxHeapSize = 0;

        Integer currentMedian = 0;

        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
            if (a[a_i].compareTo(currentMedian) < 0) {
                maxHeap[maxHeapSize++] = a[a_i];
                // making sure the max heap has maximum value at the top
                if (maxHeap[maxHeapSize - 1].compareTo(maxHeap[0]) > 0) {
                    exchange(maxHeap, maxHeapSize - 1, 0);
                }
            } else {
                minHeap[minHeapSize++] = a[a_i];
                // making sure the min heap has minimum value at the top
                if (minHeap[minHeapSize - 1].compareTo(minHeap[0]) < 0) {
                    exchange(minHeap, minHeapSize - 1, 0);
                }
            }

            // if the difference is more than one
            if (Math.abs(maxHeapSize - minHeapSize) > 1) {
                if (maxHeapSize > minHeapSize) {
                    exchange(maxHeap, maxHeapSize - 1, 0);
                    minHeap[minHeapSize++] = maxHeap[--maxHeapSize];
                    exchange(minHeap, 0, minHeapSize - 1);
                    maxHeapify(maxHeap, maxHeapSize);
                } else {
                    exchange(minHeap, minHeapSize - 1, 0);
                    maxHeap[maxHeapSize++] = minHeap[--minHeapSize];
                    exchange(maxHeap, 0, maxHeapSize - 1);
                    minHeapify(minHeap, minHeapSize);
                }
            }

            // calculate the median
            if (maxHeapSize == minHeapSize) {
                currentMedian = Integer.parseInt(String.valueOf(minHeap[0])) + Integer.parseInt(String.valueOf(maxHeap[0]));
                currentMedian = (currentMedian / 2);
            } else if (maxHeapSize > minHeapSize) {
                currentMedian = Integer.parseInt(String.valueOf(maxHeap[0]));
            } else {
                currentMedian = Integer.parseInt(String.valueOf(minHeap[0]));
            }

            System.out.println(currentMedian);

        }

    }
}


