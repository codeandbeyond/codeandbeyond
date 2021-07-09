package com.optum.fs.rest.service.util.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    private int[] rowCount = {-1, 1, 0, 0};
    private int[] colCount = {0, 0, -1, 1};

    class QueueItem {
        int row;
        int col;

        public QueueItem(int r, int c) {
            this.col = c;
            this.row = r;
        }

        @Override
        public String toString() {
            return row + " " + col;
        }
    }

    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
        int[][] grid = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };
        System.out.println(rottenOranges.orangesRotting(grid));

    }

    public int orangesRotting(int[][] grid) {
        Queue<QueueItem> rotten = new LinkedList<>();
        int freshCount = 0;
        int minutes = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    QueueItem queueItem = new QueueItem(i, j);
                    rotten.add(queueItem);
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        while (!rotten.isEmpty() && freshCount > 0) {
            int size = rotten.size();

            for (int i = 0; i < size; i++) {
                QueueItem rottenOrange = rotten.poll();
                for (int k = 0; k < 4; k++) {
                    int nextOrangeRow = rottenOrange.row + rowCount[k];
                    int nextOrangeCol = rottenOrange.col + colCount[k];
                    if (isSafe(nextOrangeCol, nextOrangeRow, grid)) {
                        rotten.offer(new QueueItem(nextOrangeRow, nextOrangeCol));
                        grid[nextOrangeRow][nextOrangeCol] = 2;
                        freshCount--;
                    }
                }
            }
            minutes++;
        }
        return freshCount != 0 ? -1 : minutes;
    }

    private boolean isSafe(int nextOrangeCol, int nextOrangeRow, int[][] grid) {
        if (nextOrangeRow < 0 || nextOrangeRow > grid.length - 1 || nextOrangeCol < 0 || nextOrangeCol > grid[0].length - 1 || grid[nextOrangeRow][nextOrangeCol] !=1 )
            return false;
        return true;
    }
}
