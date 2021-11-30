package com.optum.fs.rest.service.util.leetcode;

public class MaxOnesByFlippingKZeros {
    public static void main(String[] args) {
        MaxOnesByFlippingKZeros maxOnesByFlippingKZeros = new MaxOnesByFlippingKZeros();
        int[] A = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int K = 1;
        System.out.println( maxOnesByFlippingKZeros.longestOnes(A, K));
    }

    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;

        while (right < A.length) {

            if (A[right] == 0) {
                K--;
            }
            if (K < 0) {
                if (A[left] == 0) {
                    K++;
                }
                left++;
            }

            right++;
        }
        return right - left;

    }
}
