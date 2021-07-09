package com.optum.fs.rest.service.util.problems;

import java.util.Arrays;

public class RankOrderedArray<Key extends Comparable<Key>> {
    public static void main(String[] args) {
        RankOrderedArray<Integer> rankOrderedArray = new RankOrderedArray<Integer>();
        Integer[] a = new Integer[]{16, 17, 12, 34, 21, 98, 43, 27, 49, 32, 83, 47, 912, 37, 190};
        HeapSort.sort(a);
        System.out.println(" " + a[rankOrderedArray.floor(a, 97, 0, a.length)]);

//
//        System.out.println(" Rank of Key "+99+" is "+  rankOrderedArray.rank(a,99,0,a.length));
//        System.out.println(a[rankOrderedArray.rank(a,99,0,a.length)]);

        Integer arr1[] = new Integer[]{1, 2, 3, 4, 7, 9};
        Integer arr2[] = new Integer[]{0, 1, 2, 1, 1, 4};

        rankOrderedArray.countEleLessThanOrEqual(arr1, arr2, arr1.length, arr2.length);

    }

    void countEleLessThanOrEqual(Integer arr1[], Integer[] arr2,
                                 int m, int n) {
        // sort the 2nd array
        Arrays.sort(arr2);
        RankOrderedArray<Integer> rankOrderedArray = new RankOrderedArray<Integer>();

        // for each element of 1st array
        for (int i = 0; i < m; i++) {
            // last index of largest element
            // smaller than or equal to x
            int index = rankOrderedArray.lastOccourance(arr2, arr1[i], 0, n - 1, arr2.length);

            // required count for the element arr1[i]
            System.out.print((index + 1) + " ");
        }
    }

    public int rank(Key[] arr, Key key, int lo, int hi) {
        if (lo > hi)
            return lo;
        int mid = lo + (hi - lo) / 2;
        if (key.compareTo(arr[mid]) == 0) {
            return mid;
        } else if (key.compareTo(arr[mid]) > 0) {
            return rank(arr, key, mid + 1, hi);
        } else return rank(arr, key, lo, mid - 1);
    }

    public int lastOccourance(Key[] arr, Key key, int lo, int hi, int n) {
        if (lo > hi)
            return hi;
        int mid = lo + (hi - lo) / 2;
         if (key.compareTo(arr[mid]) < 0) {
            return lastOccourance(arr, key, lo, mid - 1, n);
        } else return lastOccourance(arr, key, mid + 1, hi, n);
    }

    public int floor(Key[] arr, Key key, int lo, int hi) {
        if (key == null)
            throw new RuntimeException("Key Can't be null");
        int i = rank(arr, key, lo, hi);
        if (i < hi && arr[i].compareTo(key) == 0)
            return i;
        else if (i == 0) {
            return -1;
        } else return (i - 1);
    }

}
