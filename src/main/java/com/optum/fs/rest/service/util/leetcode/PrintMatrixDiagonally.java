package com.optum.fs.rest.service.util.leetcode;

public class PrintMatrixDiagonally {
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int n = 3;
        printMatrixDiagonal(mat, n);
    }

    private static void printMatrixDiagonal(int[][] mat, int n) {
        int i = 0;
        int j = 0;
        boolean isUp = true;
        for (int k = 0; k < n * n; ) {
            if (isUp) {
                for (; i >= 0 && j < n; i--, j++) {
                    System.out.print(mat[i][j] + " ");
                    k++;
                }
                if (i < 0 && j <= n - 1) {
                    i = 0;
                }
                if (j == n) {
                    i = i + 2;
                    j--;
                }
            } else {
                for (; j >= 0 && i < n; i++, j--) {
                    System.out.print(mat[i][j] + " ");
                    k++;
                }
                if (j < 0 && i <= n - 1) {
                    j = 0;
                }
                if (i == n) {
                    j = j + 2;
                    i--;
                }

            }
            isUp = !isUp;
        }
    }
}
