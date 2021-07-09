package com.optum.fs.rest.service.util.leetcode;

public class ProductsExceptSelf {
    public static void main(String[] args) {
        ProductsExceptSelf productsExceptSelf = new ProductsExceptSelf();
        productsExceptSelf.products(new int[]{1, 2, 3, 4});
    }

    public int[] products(int[] nums) {
        int N = nums.length;
        int[] leftProducts = new int[N];
        int[] rightProducts = new int[N];
        int[] outPut = new int[N];

        leftProducts[0] = 1;
        rightProducts[N - 1] = 1;

        for (int i = 1; i < N; i++) {
            leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
        }
        for (int j = N - 2; j >= 0; j--) {
            rightProducts[j] = rightProducts[j + 1] * nums[j + 1];
        }
        for (int i = 0; i < N; i++) {
            outPut[i] = leftProducts[i] * rightProducts[i];
        }
        return outPut;
    }
}
