package com.optum.fs.rest.service.util.leetcode;

public class KnightTourProblem {
    int N = 64;

    public static void main(String[] args) {
        KnightTourProblem knightTourProblem = new KnightTourProblem();
        knightTourProblem.solveKT();
    }

    private void solveKT() {
        int[][] board = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = -1;
            }
        }
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        board[0][0] = 0;

        if (solveKTUtil(0, 0, 1, xMove, yMove, board)) {
            System.out.println("True");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(board[i][j] + "  ");
                }
                System.out.println("");
            }
        } else {
            System.out.println("False");
        }
    }

    private boolean solveKTUtil(int i, int j, int move, int[] xMove, int[] yMove, int[][] board) {
        int k;
        if (move == (N)) {
            return true;
        }
        for (k = 0; k < 8; k++) {
            int xNext = i+xMove[k];
            int yNext = j+yMove[k];
            if (isSafe(xNext, yNext, board)) {
                board[xNext][yNext] = move;
                if (solveKTUtil(xNext, yNext, move + 1, xMove, yMove, board)) {
                    return true;
                } else {
                    board[xNext][yNext] = -1;
                }
            }
        }
        return false;
    }

    private boolean isSafe(int xNext, int yNext, int[][] board) {
        if (xNext < 0 || xNext >= 8 || yNext < 0 || yNext >= 8 || board[xNext][yNext] != -1) {
            return false;
        }
        return true;
    }
}
