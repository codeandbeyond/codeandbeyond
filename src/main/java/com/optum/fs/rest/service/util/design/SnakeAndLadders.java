package com.optum.fs.rest.service.util.design;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        //visited[1] = true;
        int move = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int num = queue.poll();
                if (visited[num]) continue;
                visited[num] = true;
                if (num == n * n) return move;
                for (int i = 1; i <= 6 && num + i <= n * n; i++) {
                    int next = num + i;
                    int val = getValidBoardValue(board, next);
                    if (val > 0) {
                        next = val;
                    }
                    if (!visited[next]) {
                        queue.add(next);
                    }
                }
            }
            move++;
        }
        return -1;
    }

    private int getValidBoardValue(int[][] board, int num) {
        int n = board.length;
        int oldRow = (num - 1) / n;
        int row = n - oldRow - 1;
        int oldCol = (num - 1) % n;
        int col = oldRow % 2 == 0 ? oldCol : n - 1 - oldCol;
        return board[row][col];
    }

    public static void main(String[] args) {
        int[][] board = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};
        SnakeAndLadders snakeAndLadders = new SnakeAndLadders();
        System.out.println(snakeAndLadders.snakesAndLadders(board));
    }
}
