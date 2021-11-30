package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.util.Arrays;

public class SortByParity {
    public static void main(String[] args) {
        SortByParity sortByParity = new SortByParity();
        sortByParity.sortArrayByParityII(new int[]{4, 2, 5, 7});
    }

    public int[] sortArrayByParityII(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i += 1) {

            if (i % 2 == 0 && A[i] % 2 != 0) {
                swap(A, i, i + 1);
            } else if (i % 2 != 0 && A[i] % 2 == 0) {
                swap(A, i, i + 1);
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
