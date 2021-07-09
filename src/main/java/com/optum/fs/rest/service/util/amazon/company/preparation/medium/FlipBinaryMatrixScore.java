package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

public class FlipBinaryMatrixScore {
    int rows = 0;
    int columns = 0;

    public int matrixScore(int[][] A) {
        rows = A.length;
        columns = A[0].length;
        //flip the rows
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                flipRow(A, i);
            }
        }
        for (int j = 1; j < A[0].length; j++) {
            int countSum = 0;
            for (int i = 0; i < A.length; i++) {
                countSum += A[i][j];
            }
            if (columns - countSum > countSum) {
                flipColoumn(A, j);
            }
        }
        int result = 0;
        for (int i = 0; i < rows; i++) {
            result += binary(A[i]);
        }
        return result;
    }

    private int binary(int[] arr) {
        int bin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                bin += Math.pow(2, arr.length - i - 1);
            }
        }
        return bin;
    }

    private void flipColoumn(int[][] a, int column) {
        for (int i = 0; i < rows; i++) {
            a[i][column] = 1 - a[i][column];
        }
    }

    private void flipRow(int[][] A, int row) {
        for (int j = 0; j < columns; j++) {
            A[row][j] = 1 - A[row][j];
        }
    }
}
