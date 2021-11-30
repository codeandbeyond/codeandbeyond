package com.optum.fs.rest.service.util.leetcode;

import java.util.Arrays;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 6, 5};
        PythagoreanTriplet pythagoreanTriplet = new PythagoreanTriplet();
        pythagoreanTriplet.isPresent(arr);
    }

    private void isPresent(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = n - 1; i >=2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] == arr[i]) {
                    System.out.println("Present ");
                    break;

                } else if (arr[l] + arr[r] > arr[i]) {
                    r--;

                } else {
                    l++;
                }
            }
        }
    }
}
