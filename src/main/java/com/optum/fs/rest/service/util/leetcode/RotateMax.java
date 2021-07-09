package com.optum.fs.rest.service.util.leetcode;

public class RotateMax {
    public static void main(String[] args) {
        int[] A = new int[]{4, 3, 2, 6};
        RotateMax rotateMax = new RotateMax();
        rotateMax.rotate(A);
    }

    public int rotate(int[] A) {
        int allSum = 0;
        int len = A.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * A[i];
            allSum += A[i];
        }
        int max = F;
        for (int i = len - 1; i >= 1; i--) {
            F = F + allSum - len * A[i];
            max = Math.max(F, max);
        }
        return max;
    }
}
