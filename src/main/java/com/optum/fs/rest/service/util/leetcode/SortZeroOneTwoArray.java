package com.optum.fs.rest.service.util.leetcode;

public class SortZeroOneTwoArray {
    public static void main(String[] args) {
        SortZeroOneTwoArray sortZeroOneTwoArray = new SortZeroOneTwoArray();
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int n = arr.length;
        sortZeroOneTwoArray.sort(arr, n);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private void sort(int[] arr, int n) {
        int lo = 0;
        int hi = n - 1;
        int mid = 0;
        int temp;
        while (mid <= hi) {
            switch (arr[mid]) {
                case 0:
                    temp = arr[lo];
                    arr[lo] = arr[mid];
                    arr[mid] = temp;
                    lo++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[mid];
                    arr[mid] = arr[hi];
                    arr[hi] = temp;
                    hi--;
                    break;
            }
        }
    }
}
