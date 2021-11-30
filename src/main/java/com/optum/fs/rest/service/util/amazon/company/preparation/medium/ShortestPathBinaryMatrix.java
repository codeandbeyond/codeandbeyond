package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
        Queue<Pair> pairQueue = new LinkedList<>();
        pairQueue.add(new Pair(0, 0));
        grid[0][0] = 1;
        while (!pairQueue.isEmpty()) {
            int size = pairQueue.size();
            for (int i = 0; i < size; i++) {
                Pair currentPair = pairQueue.poll();
                if (currentPair.x == m - 1 && currentPair.y == n - 1) {
                    return ans + 1;
                }
                for (int k = 0; k < dir.length; k++) {
                    int nextX = currentPair.x + dir[k][0];
                    int nextY = currentPair.y + dir[k][1];
                    if (isSafe(nextX, nextY, m, n, grid)) {
                        pairQueue.add(new Pair(nextX, nextY));
                        grid[nextX][nextY] = 1;
                    }
                }
            }
            ans++;
        }
        return -1;

    }

    private boolean isSafe(int nextX, int nextY, int m, int n, int[][] grid) {
        if (nextX < 0 || nextX == m || nextY < 0 || nextY == n || grid[nextX][nextY] == 1) return false;
        return true;
    }
}
