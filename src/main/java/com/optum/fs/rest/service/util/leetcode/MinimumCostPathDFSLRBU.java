package com.optum.fs.rest.service.util.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostPathDFSLRBU {
    class cell {
        int x;
        int y;
        int distance;

        public cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {

        int grid[][] =
                {
                        {31, 100, 65, 12, 18},
                        {10, 13, 47, 157, 6},
                        {100, 113, 174, 11, 33},
                        {88, 124, 41, 20, 140},
                        {99, 32, 111, 41, 20}
                };
        MinimumCostPathDFSLRBU minimumCostPathDFSLRBU = new MinimumCostPathDFSLRBU();
        minimumCostPathDFSLRBU.minCostPath(grid, 5, 5);

    }

    private void minCostPath(int[][] grid, int row, int col) {
        int[][] distance = new int[row][col];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = grid[0][0];
        PriorityQueue<cell> priorityQueue = new PriorityQueue<>(new Comparator<cell>() {
            @Override
            public int compare(cell c1, cell c2) {
                if (c1.distance == c2.distance) {
                    if (c1.x != c2.x) {
                        return c1.x - c2.x;
                    } else {
                        return c1.y - c2.y;
                    }
                }
                return c1.distance - c2.distance;
            }
        });
        priorityQueue.add(new cell(0, 0, 0));

        while (!priorityQueue.isEmpty()) {
            cell currentCell = priorityQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = currentCell.x + dx[i];
                int nextY = currentCell.y + dy[i];
                if (isSafe(nextX, nextY, row, col)) {
                    if (distance[nextX][nextY] > distance[currentCell.x][currentCell.y] + grid[nextX][nextY]) {
                        distance[nextX][nextY] = distance[currentCell.x][currentCell.y] + grid[nextX][nextY];
                        priorityQueue.add(new cell(nextX, nextY, distance[nextX][nextY]));

                    }
                }
            }

        }
        System.out.println(distance[row - 1][col - 1]);

    }

    private boolean isSafe(int nextX, int nextY, int row, int col) {
        return nextX >= 0 && nextX < row && nextY >= 0 && nextY < col;
    }
}
