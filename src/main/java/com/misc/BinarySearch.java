package com.misc;

public class BinarySearch {
    public static int search(int arr[], int low, int high, int searchElement) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == searchElement) {
                return mid;
            } else if (arr[mid] > searchElement) {
                return search(arr, mid + 1, high, searchElement);
            } else
                return search(arr, low, mid - 1, searchElement);
        }
        return -1;
    }
}

