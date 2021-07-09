package com.optum.fs.rest.service.util.leetcode;

public class SmallestPositiveUnSortedArray {
    public static void main(String[] args) {
        int arr[] = {0, 10, 2, -10, -20};
        int arr_size = arr.length;
        int missing = findMissing(arr, arr_size);
        System.out.println("The smallest positive missing number is " + missing);
    }

    private static int findMissing(int[] arr, int size) {
        int shift = seggregate(arr, size);
        int[] arr2 = new int[size - shift];
        int j = 0;
        for (int i = shift; i < size; i++) {
            arr2[j] = arr[i];
            j++;
        }
        int missingNumber = findMissingNumber(arr2, j);
        return missingNumber;
    }

    private static int findMissingNumber(int[] arr2, int size) {
        for (int i = 0; i < size; i++) {
            int x = Math.abs(arr2[i]);
            if (x - 1 < size && arr2[x - 1] > 0) {
                arr2[x - 1] = -arr2[x - 1];
            }
        }
        for (int i = 0; i < size; i++) {
            if (arr2[i] > 0) return i + 1;
        }
        return size + 1;
    }

    private static int seggregate(int[] arr, int size) {
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return j;
    }
}
