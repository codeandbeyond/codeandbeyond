package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

public class SortedSubsequence {
    public static void main(String[] args) {
        SortedSubsequence sortedSubsequence = new SortedSubsequence();
        int arr[] = {12, 11, 10, 5, 6, 2, 30};
        sortedSubsequence.find3Numbers(arr);
    }

    private void find3Numbers(int[] arr) {
        int n = arr.length;
        int[] smaller = new int[n];
        int[] greater = new int[n];
        int min = 0;
        int max = n - 1;
        smaller[0] = -1;
        greater[n - 1] = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[min]) {
                min = i;
                smaller[i] = -1;
            } else {
                smaller[i] = min;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[max]) {
                max = i;
                greater[i] = -1;
            } else {
                greater[i] = max;
            }
        }
        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                System.out.print(arr[smaller[i]] + " " + arr[i] + " " + arr[greater[i]]);
            }
        }
    }
}

