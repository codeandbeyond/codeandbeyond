package com.optum.fs.rest.service.util.leetcode;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        CelebrityProblem celebrityProblem = new CelebrityProblem();
        int mat[][] = {{0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}};

        System.out.println(celebrityProblem.findCelebrity(mat));
        System.out.println(celebrityProblem.findCelebrityTwoPointers(mat, mat.length));
    }

    private int findCelebrity(int[][] mat) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < mat.length; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if (knows(mat, a, b)) {
                stack.push(b);
            } else if (knows(mat, b, a)) {
                stack.push(a);
            }
        }
        int c = stack.pop();
        boolean isCelebrity = true;
        for (int i = 0; i < mat.length; i++) {
            if (i != c && (knows(mat, c, i) || !knows(mat, i, c))) {
                isCelebrity = false;
                break;
            }
        }
        return isCelebrity ? c : -1;
    }

    private boolean knows(int[][] mat, int a, int b) {
        return mat[a][b] == 1 ? true : false;
    }

    private int findCelebrityTwoPointers(int[][] mat, int n) {
        int a = 0;
        int b = n - 1;
        while (a < b) {
            if (knows(mat, a, b)) {
                a++;
            } else {
                b--;
            }
        }
        boolean isCelebrity = true;
        for (int i = 0; i < mat.length; i++) {
            if (i != a && (knows(mat, a, i) || !knows(mat, i, a))) {
                isCelebrity = false;
                break;
            }
        }
        return isCelebrity ? a : -1;
    }
}
