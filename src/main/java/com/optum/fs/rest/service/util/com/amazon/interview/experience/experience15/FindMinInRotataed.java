package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class FindMinInRotataed {
    public static void main(String[] args) {
        int arr[] = {4, 2};
        int min = findMin(arr, 0, arr.length - 1);
        System.out.println("The minimum element is " + min);
    }

    private static int findMin(int[] arr, int low, int high) {
        if (low > high)
            return arr[0];
        if (high == low)
            return arr[low];
        int mid = low + (high - low) / 2;

        if (mid < high && arr[mid] > arr[mid + 1])
            return arr[mid+1];
        if (mid > low && arr[mid - 1] > arr[mid])
            return arr[mid];
        if (arr[mid] < arr[high])
            return findMin(arr, low, mid - 1);
        return findMin(arr, mid + 1, high);

    }
}
