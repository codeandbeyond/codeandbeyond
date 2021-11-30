package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import java.util.Stack;

public class SpiralMatrix {
    static Stack<Integer> reverseSpiral = new Stack<Integer>();

    public static void main(String[] args) {

        int R = 3, C = 3;
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printMatrixSpiral(mat, R, C, reverseSpiral);
        System.out.println("-----Reverse Spiral--");
        for (int i = reverseSpiral.size() - 1; i >= 0; i--) {
            System.out.print(reverseSpiral.get(i) + " ");
        }
    }

    private static void printMatrixSpiral(int[][] mat, int r, int c, Stack<Integer> reverseSpiral) {
        int top = 0, bottom = r - 1, left = 0, right = c - 1;
        int dir = 0;
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int k = left; k <= right; k++) {
                    reverseSpiral.add(mat[top][k]);
                    System.out.print(mat[top][k] + " ");
                }
                top++;
            } else if (dir == 1) {
                for (int k = top; k <= bottom; k++) {
                    reverseSpiral.add(mat[k][right]);
                    System.out.print(mat[k][right] + " ");
                }
                right--;
            } else if (dir == 2) {
                for (int k = right; k >= left; k--) {
                    reverseSpiral.add(mat[bottom][k]);
                    System.out.print(mat[bottom][k] + " ");
                }
                bottom--;
            } else if (dir == 3) {
                for (int k = bottom; k >= top; k--) {
                    reverseSpiral.add(mat[k][left]);
                    System.out.print(mat[k][left] + " ");
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }

    }
}
